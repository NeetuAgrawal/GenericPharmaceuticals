package daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp pc
 */
public class GenpharmaDAO {
    Connection con;
    
    public Connection getConnection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/genpharma","root","enlighten");
        }
        catch(Exception e){
            System.out.println("Exception found here in getConnection() :  "+e);
        }
        return con;
        }
    
    public int getVoucherId(String vType){
        int id=0;
        try{
        getConnection();
       Statement stmt= con.createStatement();
      ResultSet rset= stmt.executeQuery("select voucher_id from voucher where codeName='"+vType+"'");
       if(rset.next()){
           id=rset.getInt(1);
       }
       rset.close();
       stmt.close();
       con.close();
    }
        catch(Exception e){
     System.out.println("Exception found in getVoucherId() :"+e);       
        }
        return id;
    }
    
    public void saveEmpVoucher(int id,String type,String date,float amount,String description,String billNo, String fileLoc){
        
         try{
        getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into user_voucher(user_id,voucher_id,status_id,creationTime,bill_date,amount,description,bill_no,imageURL) values(?,?,?,?,?,?,?,?,?)");
       stmt.setInt(1,id);
        stmt.setInt(2,getVoucherId(type));
        stmt.setInt(3,1);
        stmt.setTimestamp(4, getCurrentTimestamp());
        stmt.setString(5,date);
        stmt.setFloat(6, amount);
        stmt.setString(7, description);
        stmt.setString(8,billNo);
        stmt.setString(9,fileLoc);
        
        stmt.executeUpdate();
        
       stmt.close();
       con.close();
    }
        catch(Exception e){
     System.out.println("Exception found in getVoucherId() :"+e);       
        }
       
    }
    
    public Timestamp getCurrentTimestamp(){
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        return currentTimestamp;
    }
    
    
}
