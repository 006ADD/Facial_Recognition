/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.ModelPerson;
import Util.Connecor;
import Util.Model;
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


public class PersonDAO {
    private Connecor connect = new Connecor(); 

    public void insert(ModelPerson mod) {
    try {
         // Подключаемся к базе данных
        connect.connection();

        // Получаем текущее время в формате "yyyy-MM-dd HH:mm:ss"
        String registrationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Подготавливаем SQL-запрос для вставки данных
        PreparedStatement pst = connect.conn.prepareStatement("INSERT INTO person (id, firstName, lastName, position, yearOfBirth, registrationTime) VALUES (?, ?, ?, ?, ?, ?)");
        pst.setInt(1, mod.getId());
        pst.setString(2, mod.getFirstName());
        pst.setString(3, mod.getLastName());
        pst.setString(4, mod.getPosition());
        pst.setString(5, mod.getYearOfBirth());
        pst.setString(6, mod.getRegistrationTime()); // Вставляем текущее время регистрации

        // Выполняем запрос на вставку данных
        pst.executeUpdate();
        
        // Выводим сообщение об успешной регистрации в консоль
        System.out.println("Data for " + mod.getFirstName() + " registered successfully.");

        // Отключаемся от базы данных
        connect.disconnect();
       
    } catch (SQLException ex) {
        System.out.println("Error: " + ex);
    }
}

   public void update(ModelPerson mod, int id) {
        connect.connection();
        try {
            PreparedStatement pst = connect.conn.prepareStatement("UPDATE person SET firstName= ?, lastName= ?, position= ?, yearOfBirth= ?, registrationTime= ? WHERE id=?");

            //String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pst.setString(1, mod.getFirstName());
            pst.setString(2, mod.getLastName());
            pst.setString(3, mod.getPosition());
            pst.setString(4, mod.getYearOfBirth());
            pst.setString(5, mod.getRegistrationTime());
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

    public void filltable(String SQL, JTable tabel) throws SQLException {
        String id = null;

        connect.connection();
        ArrayList list = new ArrayList();
        String[] columns = new String[]{"Photo", "ID", "Name", "Phone", "Position","Time"};
       // String[] columns = new String[]{"Photo" ,"ID", "Name", "LastName", "Position", "EnterTime"};
        connect.executeSQL(SQL);
        try {
            if (connect.rs.next()) { // Проверяем, есть ли строки в результате запроса
                do {
                    list.add(new Object[]{
                        "",
                        connect.rs.getString("id"),
                        connect.rs.getString("firstName"),
                        connect.rs.getString("lastName"),
                        connect.rs.getString("position"),
                        connect.rs.getString("registrationTime")
                         
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

        Model model = new Model(list, columns);
        tabel.setModel((TableModel) model);
        tabel.getColumnModel().getColumn(0).setCellRenderer(new PersonDAO.ImageRenderer());
        tabel.getColumnModel().getColumn(1).setMaxWidth(0);
        tabel.getColumnModel().getColumn(1).setMinWidth(0);
        tabel.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabel.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
