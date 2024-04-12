/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

//import com.kingaspx.util.ConnectBanco;
//import com.kingaspx.util.Model;
/**import java.awt.Component;
import java.awt.Image;
import java.io.File;*/
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
/*import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;*/

public class ControlPerson {
    Connecor connect = new Connecor(); 

    public void insert(ModelPerson mod) {
    try {
        connect.connection();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        PreparedStatement pst = connect.conn.prepareStatement("INSERT INTO person (id, first_name, last_name, yearOfBirth, position, registrationTime ) VALUES (?, ?, ?, ?, ?, ?)");
        pst.setInt(1, mod.getId());
        pst.setString(2, mod.getFirstName());
        pst.setString(3, mod.getLastName());
        pst.setString(4, mod.getYearOfBirth());
       // pst.setInt(4, Integer.parseInt(mod.getYearOfBirth())); // Преобразуем строку в int
        pst.setString(5, mod.getPosition());
        pst.setString(6, date);
        //pst.setTimestamp(6, new Timestamp(System.currentTimeMillis())); // Вставляем текущее время
         
        pst.executeUpdate();
        System.out.println("Data from(a): " + mod.getFirstName() + " registered");
        connect.disconnect();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex);
    }
}
    /*public void insert(ModelPerson mod) {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
       try {
            connect.connection();
            PreparedStatement pst = connect.conn.prepareStatement("INSERT INTO person (id, first_name, last_name, dob, office, registration_time) VALUES (?, ?, ?, ?, ?, ?)");
           pst.setInt(1, mod.getId());
            pst.setString(2, mod.getFirst_name());
            pst.setString(3, mod.getLast_name());
             pst.setString(4, mod.getOffice());
            pst.setString(5, mod.getDob());
            pst.setTimestamp(6, Timestamp.valueOf(mod.getRegistrationTime()));
         
            pst.executeUpdate();
            System.out.println("Data from(a): " + mod.getFirst_name() + " registered");
            connect.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }*/

   public void update(ModelPerson mod, int id) {
        connect.connection();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("UPDATE person SET first_name= ?, last_name= ?, yearOfBirth= ?, position= ?, WHERE id=?");

            //String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pst.setString(1, mod.getFirstName());
            pst.setString(2, mod.getLastName());
            pst.setString(3, mod.getYearOfBirth());
            pst.setString(4, mod.getPosition());
//pst.setTimestamp(5, Timestamp.valueOf(formattedDateTime));
            //pst.setString(6, setRegistrationTime(LocalDateTime.now()));
            pst.setString(5, null);
            pst.setInt(6, id);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating data\n error: " + ex);
        }
        connect.disconnect();
    }

    public void delete(int id) {
        connect.connection();
        try (PreparedStatement pst = connect.conn.prepareStatement("DELETE FROM person WHERE id= '" + id + "'")){
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when deleting apartment. Please Try Again!");
        } 
    }

    public void filltable(String SQL, JTable tabela) throws SQLException {
        String id = null;

        connect.connection();
        ArrayList list = new ArrayList();
        String[] columns = new String[]{"", "ID", "Name", "Phone", "Function"};
        connect.executeSQL(SQL);
        try {
            if (connect.rs.next()) { // Проверяем, есть ли строки в результате запроса
                do {
                    list.add(new Object[]{
                        "",
                        connect.rs.getString("id"),
                        connect.rs.getString("first_name"),
                        connect.rs.getString("last_name"),
                        connect.rs.getString("office"),
                         
                    });
                } while (connect.rs.next());
            } else {
                //JOptionPane.showMessageDialog(rootPane, "Список регистрации пуст!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Выводим информацию об ошибке в консоль
            //JOptionPane.showMessageDialog(rootPane, "Ошибка при работе с базой данных!");
        } finally {
            if (connect != null) {
                connect.disconnect(); // Проверяем, что объект connect не равен null перед вызовом disconnect()
            }
        }

        Model modelo = new Model(list, columns);
        tabela.setModel((TableModel) modelo);
        tabela.getColumnModel().getColumn(0).setCellRenderer(new ControlPerson.ImageRenderer());
        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getColumnModel().getColumn(1).setMinWidth(0);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabela.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    class ImageRenderer implements TableCellRenderer {

        public JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                Object text = table.getValueAt(row, 1);
                File image = new File("C:\\photos\\person." + text + ".1.jpg");
                String path = image.getAbsolutePath();
                ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage().getScaledInstance(lbl.getWidth() + 50, lbl.getHeight() + 50, Image.SCALE_SMOOTH));
                lbl.setIcon(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lbl;
        }
    }

    public void editar(ModelPerson mod, int id) {
        connect.connection();
        try (PreparedStatement pst = connect.conn.prepareStatement("UPDATE apto SET apto= ? WHERE id=? ")){
            pst.setString(1, mod.getFirstName());
            pst.setInt(2, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Changed successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error when changing apartment. Please Try Again!");
        } finally {
            connect.disconnect();
        }
    }
}
