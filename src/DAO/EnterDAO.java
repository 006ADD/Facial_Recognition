package DAO;

import Entity.Enter;
import Util.Connecor;
import Util.Model;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class EnterDAO {

    private Connecor connect = new Connecor();

    public void insert(Enter enter) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.
                prepareStatement("INSERT INTO Enter ( person_id, enterdate) VALUES (?,?)")) {
            statement.setInt(1, enter.getPersonId());
            statement.setString(2, enter.getEnterDate());
            statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public ResultSet getAll() throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("SELECT * FROM Enter")) {
            return statement.executeQuery();
        }
    }

    public void delete(int id) throws SQLException {
        connect.connection();
        try (PreparedStatement statement = connect.conn.prepareStatement("DELETE FROM Enter WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            connect.disconnect();
        }catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    public void filltable(String SQL, JTable tabel) throws SQLException {
        String id = null;

        connect.connection();
        ArrayList list = new ArrayList();
        //String[] columns = new String[]{"Photo" ,"ID", "Name", "LastName", "Position", "EnterTime"};
        String[] columns = new String[]{"photo","person_id","EnterTime"};
        connect.executeSQL(SQL);
        try {
            if (connect.rs.next()) { // Проверяем, есть ли строки в результате запроса
                do {
                    list.add(new Object[]{
                        "",
                        //connect.rs.getString("id"),
                        connect.rs.getString("person_id"),
                        connect.rs.getString("enterDate")
                         
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
        tabel.getColumnModel().getColumn(0).setCellRenderer(new EnterDAO.ImageRenderer());
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
}
