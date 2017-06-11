/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manish
 */
public class DBCon {
    public static Connection con;
    private static String dbURL = "jdbc:mysql://localhost:3306/genpharma";
    private static String userName="root";
    private static String password="enlighten";
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(con==null){
            con=DriverManager.getConnection(dbURL,userName,password);
            }
        }
    catch(Exception e){
    System.out.println("Exception found while creating connection : "+ e);
    }
        return con;
  }
    
    public static void closeConnection(){
        try{
        if(con!=null){
            con.close();
        }
        }
        catch(Exception e){
            System.out.println("Exception found while closing connection  :  "+e);
        }
    }
}
