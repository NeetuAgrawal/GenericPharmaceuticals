package daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
      ResultSet rset= stmt.executeQuery("select id from voucher where shortName='"+vType+"'");
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
    
    public void saveEmpVoucher(String type,String date,float amount,String description,String billNo, String fileLoc){
        
         try{
        getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into user_voucher(user_id,voucher_id,status_id,creationTime,bill_date,amount,description,bill_no,imageURL) values(?,?,?,?,?,?,?,?,?)");
       stmt.setInt(1,1);
        stmt.setInt(2,getVoucherId(type));
        stmt.setString(3,date);
        stmt.setFloat(4, amount);
        stmt.setString(5, description);
        stmt.setString(6,billNo);
        stmt.setString(7,fileLoc);
        
        stmt.executeUpdate();
        
       stmt.close();
       con.close();
    }
        catch(Exception e){
     System.out.println("Exception found in getVoucherId() :"+e);       
        }
       
    }
}
