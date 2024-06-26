/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DAO;

import Util.Connecor;
import Entity.ModelPerson;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class Viewer extends javax.swing.JDialog {
    //private KGradientPanel kGradientPanel1;
int id;
    Connecor connect = new Connecor();
    PersonDAO controlPerson = new PersonDAO();
    
    /*public Viewer(String user) {
        initComponents();
    }*/
   public Viewer(java.awt.Frame parent, boolean modal) throws SQLException {
    super(parent, modal);
    initComponents(); // Вызов инициализации компонентов
    paint_table();
    controlPerson.filltable("SELECT * FROM person ORDER BY id", table);
}
    
    public Viewer(String user) throws SQLException{
        initComponents();
        paint_table();
        controlPerson.filltable("SELECT * FROM person ORDER BY id", table);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_position = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_yearOfBirth = new javax.swing.JTextField();
        txt_registrationTime = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_search.setForeground(new java.awt.Color(169, 169, 169));
        txt_search.setText("Поиск");
        txt_search.setBorder(null);
        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchFocusLost(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 780, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.setFillsViewportHeight(true);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 390, 380));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(118, 118, 118));
        jLabel2.setText("Фамилия");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel3.setForeground(new java.awt.Color(118, 118, 118));
        jLabel3.setText("Должность");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel9.setForeground(new java.awt.Color(118, 118, 118));
        jLabel9.setText("Время регистрации");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        txt_name.setBorder(null);
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 30));

        txt_lastname.setBorder(null);
        jPanel2.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 160, 30));

        txt_position.setBorder(null);
        txt_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_positionActionPerformed(evt);
            }
        });
        jPanel2.add(txt_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 350, 30));

        jLabel10.setForeground(new java.awt.Color(118, 118, 118));
        jLabel10.setText("Имя");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_yearOfBirth.setBorder(null);
        txt_yearOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_yearOfBirthActionPerformed(evt);
            }
        });
        jPanel2.add(txt_yearOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 30));

        txt_registrationTime.setBorder(null);
        jPanel2.add(txt_registrationTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 170, 30));

        jLabel11.setForeground(new java.awt.Color(118, 118, 118));
        jLabel11.setText("Дата рождения");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 390, 250));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(135, 135, 136));
        jLabel12.setText("Информация");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(57, 129, 215));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 680, 40));

        jButton2.setText("удалить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 110, 40));

        jButton3.setText("сохранить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 110, 40));

        txt_id_label.setBackground(new java.awt.Color(132, 242, 145));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(0, 0, 51));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 40, 40));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setText("close");
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        txt_search.setText("");
        txt_search.setForeground(new java.awt.Color(32, 32, 32));
    }//GEN-LAST:event_txt_searchFocusGained

    private void txt_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchFocusLost

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        try {
            controlPerson.filltable("SELECT * FROM person WHERE firstName LIKE '%" + txt_search.getText() + 
                                        "%' OR lastName LIKE '%" +txt_search.getText() + 
                                        "%' OR office LIKE '%" + txt_search.getText() + 
                                        "%' ORDER BY id", table);
        } catch (SQLException ex) {
            Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        txt_search.setForeground(new java.awt.Color(169, 169, 169));
        txt_search.setText("Поиск...");
    }//GEN-LAST:event_tableFocusGained

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        connect.connection();
        try {
            String nome = "" + table.getValueAt(table.getSelectedRow(), 1);
            connect.executeSQL("SELECT * FROM person WHERE id = '" + nome + "'");
            connect.rs.first();
            id = connect.rs.getInt("id");
            txt_id_label.setText(String.valueOf(id));
            txt_name.setText(String.valueOf(connect.rs.getString("firstName")));
            txt_lastname.setText(String.valueOf(connect.rs.getString("lastName")));
            txt_position.setText(String.valueOf(connect.rs.getString("position")));
            txt_yearOfBirth.setText(String.valueOf(connect.rs.getString("yearOfBirth")));
            txt_registrationTime.setText(String.valueOf(connect.rs.getString("registrationTime")));


        } catch (SQLException s) {
            //JOptionPane.showMessageDialog(rootPane, "" + s);
        }
        connect.disconnect();
    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        /*if (evt.isPopupTrigger()) {//Se o mouse foi clicado com o botão de PopupMenu default do sistema operacional em uso
            jPopupMenu1.show(tabel, evt.getX(), evt.getY()); //p é o JPopupMenu, t é a tabela, e.getX() recupera a posição horizontal do mouse e e.getY() recupera a posição vertical.
        }*/
    }//GEN-LAST:event_tableMouseReleased

    private void txt_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_positionActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ModelPerson mod = new ModelPerson();
        mod.setId(id);
        controlPerson.delete(mod.getId());
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         ModelPerson mod = new ModelPerson();
        mod.setId(id);
        mod.setFirstName(txt_name.getText());
        mod.setLastName(txt_lastname.getText());
        mod.setPosition(txt_position.getText());
         mod.setYearOfBirth(txt_yearOfBirth.getText());
         mod.setRegistrationTime(txt_registrationTime.getText());
        controlPerson.update(mod, id);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_yearOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_yearOfBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_yearOfBirthActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Viewer dialog = new Viewer(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_position;
    private javax.swing.JTextField txt_registrationTime;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_yearOfBirth;
    // End of variables declaration//GEN-END:variables
 private void paint_table() {
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(60, 127, 177));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(50);
    }
}
