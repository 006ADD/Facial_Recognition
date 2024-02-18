/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBanco {
    public Statement stm;
    public ResultSet rs;
    public Connection conn;
    
    private final String driver = "org.postgresql.Driver";
    private final String path = "jdbc:postgresql://localhost:5432/Facial_recognition";
    private final String user = "postgres";
    private final String pass = "pgAdmin666";
    
    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(path, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
     
    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    public void executaSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args){
        ConnectBanco ds = new ConnectBanco();
        ds.conexao();
    }
}
