/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author vitor
 */
public class ConnectionFactory {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/sgc";
    private static String USER = "root";
    private static String PASS = "";
    
   public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
   }
   public static void closeConnection(Connection con){
       if(con != null){
           try {
               con.close();
           } catch (SQLException ex) {
               System.err.println("Erro: "+ex);
           }
       }
   }
   public static void closeConnection(Connection con, PreparedStatement stmt){
       if(stmt != null){
           try {
               stmt.close();
           } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
           }
       }
       closeConnection(con);
   }
   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
       if(rs != null){
           try {
               rs.close();
           } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
           }
       }
       closeConnection(con, stmt);
   }
    
}
