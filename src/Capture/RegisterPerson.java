package Capture;

import Util.Connecor;
import DAO.PersonDAO;
import Entity.ModelPerson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterPerson extends javax.swing.JFrame {

    Connecor connector = new Connecor();
    PersonDAO cod;
    ModelPerson mod;
    public RegisterPerson() {
        initComponents();
        showIdUser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_id_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_position = new javax.swing.JTextField();
        txt_first_name = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        txt_yearOfBirth = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security System - Register Person");
        setBackground(new java.awt.Color(238, 218, 62));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        jPanel2.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 430, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Фамилия");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel3.setText("Год рождения");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setText("Должность ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 96, -1, 20));

        jLabel5.setText("Имя");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txt_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_positionActionPerformed(evt);
            }
        });
        jPanel3.add(txt_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 160, -1));

        txt_first_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_first_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        txt_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_last_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 160, -1));

        try {
            txt_yearOfBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txt_yearOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 430, 180));

        jButton1.setBackground(new java.awt.Color(92, 96, 209));
        jButton1.setText("Сфотографировать");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 360));

        setSize(new java.awt.Dimension(478, 382));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_positionActionPerformed

    }//GEN-LAST:event_txt_positionActionPerformed

    private void txt_first_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_first_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_first_nameActionPerformed

    private void txt_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_last_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String firtsName = txt_first_name.getText();
            String lastName=txt_last_name.getText();
            String position = txt_position.getText();
            String yearOfBirth =txt_yearOfBirth.getText();
            int id = Integer.parseInt(txt_id_label.getText().replace("ID ", ""));
            LocalDateTime registrationTime = LocalDateTime.now(); // Получаем текущее время
    
            // Выводим время регистрации в консоль
            System.out.println("Registration Time: " + registrationTime);
    
            // Преобразуем время регистрации в строку в нужном формате, например, для вывода на экран
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedRegistrationTime = registrationTime.format(formatter);
            System.out.println("Formatted Registration Time: " + formattedRegistrationTime);
            
// Вызываем метод insert и передаем ему полученные данные
            
        
           new Capture(id, firtsName, lastName, position, yearOfBirth, formattedRegistrationTime).setVisible(true);
         
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPerson().setVisible(true);
            }
        });
        
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_position;
    private javax.swing.JFormattedTextField txt_yearOfBirth;
    // End of variables declaration//GEN-END:variables
       
    
    private void showIdUser() {
        connector.connection();
        connector.executeSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
            try {
                if (connector.rs.next()) {
                   int id = connector.rs.getInt("id") + 1;
                    txt_id_label.setText("ID " + id);
                    LocalDateTime registrationTime = LocalDateTime.now(); // Получаем текущее время
                    // Сохраняем время регистрации в базе данных
                    saveRegistrationTime(id, registrationTime);
                } else {
                    // Если таблица пустая, начинаем с id = 1
                    txt_id_label.setText("ID 1");
                    LocalDateTime registrationTime = LocalDateTime.now(); // Получаем текущее время
                    // Сохраняем время регистрации в базе данных
                    saveRegistrationTime(1, registrationTime);
                }
            } catch (Exception e) {
        // Обработка ошибок
            }   
    }
    
    private void saveRegistrationTime(int id, LocalDateTime registrationTime){
        
    }

}
