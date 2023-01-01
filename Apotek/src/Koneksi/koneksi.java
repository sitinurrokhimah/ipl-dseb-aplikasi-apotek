package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class koneksi {
    Connection connect;
    Statement sttmnt;
    ResultSet rslt;
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost/apkapotek";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil !!!", "Report Koneksi",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
        	System.err.println("Exception: " + e.getMessage());
        }
        return koneksi;
    
    }
}
