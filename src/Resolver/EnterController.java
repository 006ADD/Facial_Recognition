/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Resolver;

import DAO.EnterDAO;
import DAO.ControllerDB;
import Entity.ControllerModel;
import Entity.Enter;
import Entity.Exit;
import Resolver.Recognizer;
import Util.Connecor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

/**
 *
 * @author User
 */
public class EnterController extends javax.swing.JFrame {

    private EnterController.DaemonThread myThread = null;

    //JavaCV
    VideoCapture webSource = null;
    Mat cameraImage = new Mat();
    CascadeClassifier cascade = new CascadeClassifier("C:\\photos\\haarcascade_frontalface_alt.xml");
    FaceRecognizer recognizer = LBPHFaceRecognizer.create();
    BytePointer mem = new BytePointer();
    RectVector delectedFaces = new RectVector();

    //Vars
    private String root, firstName, lastName, position, yearOfBirth;
    int idPerson;

    //Utils
    Connecor connect = new Connecor();

    public EnterController(String user) {
        initComponents();
        recognizer.read("C:\\photos\\classifierLBPH.yml");
        recognizer.setThreshold(80);
        startCamera();
    }

    public EnterController() {
        
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label_position = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        label_enterTime = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        label_id = new javax.swing.JLabel();
        label_photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_position.setBackground(new java.awt.Color(92, 96, 209));
        label_position.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_position.setForeground(new java.awt.Color(255, 255, 255));
        label_position.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_position.setText("должность");
        label_position.setOpaque(true);
        jPanel2.add(label_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 390, 50));

        label_name.setBackground(new java.awt.Color(92, 96, 209));
        label_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_name.setForeground(new java.awt.Color(255, 255, 255));
        label_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_name.setText("Имя");
        label_name.setOpaque(true);
        jPanel2.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 390, 50));

        label_enterTime.setBackground(new java.awt.Color(92, 96, 209));
        label_enterTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_enterTime.setForeground(new java.awt.Color(255, 255, 255));
        label_enterTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_enterTime.setText("Время прихода");
        label_enterTime.setOpaque(true);
        jPanel2.add(label_enterTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 390, 50));

        save.setText("отпечаток");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, 80));

        label_id.setBackground(new java.awt.Color(92, 96, 209));
        label_id.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_id.setForeground(new java.awt.Color(255, 255, 255));
        label_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_id.setText("ID");
        label_id.setOpaque(true);
        jPanel2.add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 390, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 410, 370));

        label_photo.setForeground(new java.awt.Color(240, 240, 240));
        label_photo.setText("jLabel2");
        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        jPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 310));

        jButton1.setText("Закрыть");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stopCamera();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        ControllerDB controllerDB = new ControllerDB();
        //EnterDAO enterDAO = new EnterDAO();
        ControllerModel controllerModel = new ControllerModel();
        //Enter enter = new Enter();
        try {
            String idString = label_id.getText();
            // Проверка на то, что строка не пуста и содержит числовое значение
            if (!idString.isEmpty() && idString.matches("\\d+")) {
                // Преобразование строки в целое число
                int personId = Integer.parseInt(idString);

                // Установка значения personId в объекте enter
                controllerModel.setPersonId(personId);
                //enter.setPersonId(personId);
            }
            controllerModel.setEnterDate(time());
            //enter..setEnterDate(time());

            controllerDB.insertEnter(controllerModel);
            //enterDAO.insertEnter(controllerModel);
        } catch (SQLException ex) {
            Logger.getLogger(ExitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Successfully-----------------------------------------------------------------------------------------------)");
    }//GEN-LAST:event_saveActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_enterTime;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_photo;
    private javax.swing.JLabel label_position;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
   class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics();

                            Mat imageGray = new Mat();
                            cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                            RectVector detectedFace = new RectVector();
                            cascade.detectMultiScale(imageGray, detectedFace, 1.1, 2, 0, new Size(150, 150), new Size(500, 500));

                            for (int i = 0; i < detectedFace.size(); i++) {
                                Rect dadosFace = detectedFace.get(i);
                                rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 0));
                                Mat faceCapturada = new Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

                                IntPointer rotulo = new IntPointer(1);
                                DoublePointer confidence = new DoublePointer(1);
                                recognizer.predict(faceCapturada, rotulo, confidence);
                                int prediction = rotulo.get(0);
                                String nome;
                                nome = firstName;

                                if (prediction == -1) {
                                    /**
                                     * rectangle(cameraImage, dadosFace, new
                                     * Scalar(0, 0, 255, 3), 3, 0, 0); idPerson
                                     * = 0;
                                     */
                                    label_name.setText("Не нашли");
                                    label_position.setText("");
                                    idPerson = 0;

                                } else {
                                    //rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                    System.out.println(confidence.get(0));
                                    //idPerson = prediction;
//                                    System.out.println("PESSOA RECONHECIDA COMO: " + idPerson);
                                    idPerson = prediction;
                                    rec();
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;

                            try {
                                if (g.drawImage(buff, 0, 0, 360, 390, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    if (runnable == false) {
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }

    private void rec() {
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                connect.connection();
                try {
                    String SQL = "SELECT * FROM Person WHERE id = " + String.valueOf(idPerson);
                    connect.executeSQL(SQL);
                    while (connect.rs.next()) {
                        label_id.setText(connect.rs.getString("id"));
                        label_name.setText(connect.rs.getString("firstName"));

                        label_enterTime.setText(time());
                        //label_exitTime.setText(connect.rs.getString("exitTime"));
                        //+ " " + connect.rs.getString("last_name"));
                        label_position.setText(connect.rs.getString("position"));

                        //System.out.println("Person: "+ connect.rs.getString("id - ")+ connect.rs.getString("firstName"));
                        java.sql.Array ident = connect.rs.getArray("firstName");
                        String[] person = (String[]) ident.getArray();

                        for (int i = 0; i < person.length; i++) {
                            System.out.println(person[i]);
                        }

                    }
                } catch (Exception e) {

                }
                connect.disconnect();
                return null;
            }
        };
        worker.execute();
    }

    public void stopCamera() {
        try {
            myThread.runnable = false;
            webSource.release();
            dispose();
        } catch (Exception e) {
        }
    }

    public void startCamera() {
        new Thread() {
            @Override
            public void run() {
                webSource = new VideoCapture(0);
                myThread = new EnterController.DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        }.start();
    }

    public String time() {
        LocalDateTime registrationTime = LocalDateTime.now(); // Получаем текущее время

        // Преобразуем время регистрации в строку в нужном формате, например, для вывода на экран
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedRegistrationTime = registrationTime.format(formatter);
        return formattedRegistrationTime;
    }

}
