/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import models.User;

/**
 *
 * @author manish
 */
public class UserDAO {
    //registering
    Connection con;
    public UserDAO(){
    con=DBCon.getConnection();
    }

    public boolean addUser(User user){
        //check whether the same person exist with same email id
        try{
        boolean exist = doesUserExist(user.getEmailId());
        if(exist){
            
            return false;
        }
        else{
             //fetch roll_id
             
               PreparedStatement pstmt = con.prepareStatement("insert into user(fname,lname,gender,email_id,password,role) values(?,?,?,?,?,?)");
                pstmt.setString(1,user.getFirstName());
                pstmt.setString(2,user.getLastName());
                pstmt.setString(3,user.getGender());
                pstmt.setString(4,user.getEmailId());
                pstmt.setString(5,user.getPassword());
                pstmt.setString(6,user.getRole());
                
                pstmt.executeUpdate();
                
                pstmt.close();
                //con.close();
                
                return true;
               
             }
        }
   
        catch(Exception ex){
            System.out.println("Exception found in addUser() method : "+ex);
        }
          return false;
          
    }
    //for signing in
    public boolean doesUserExist(String emailId){
        try{
           
            if(con!=null){
                Statement stmt = con.createStatement();
                ResultSet rset=stmt.executeQuery("select * from user where email='"+emailId+"'");
                
                if(rset.next()){
                     rset.close();stmt.close();
                    return true;
                }
                else{
                    rset.close();stmt.close();
                    return false;
                }
            }
        }
        catch(Exception ex){
            System.out.println("Exception found in doesUserExist method() "+ex);
        }
        return false;
    }
    
    
     //for logging in
    public User doesUserExist(String role,String emailId,String password){
        try{
           
            if(con!=null){
                Statement stmt = con.createStatement();
                ResultSet rset=stmt.executeQuery("select * from user where email_id='"+emailId+"' and password='"+password+"'and role= '"+role+"'");
                
                if(rset.next()){
                    User user= new User(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6));
                     rset.close();stmt.close();
                    return user ;
                }
                else{
                    rset.close();stmt.close();
                    return null;
                }
            }
        }
        catch(Exception ex){
            System.out.println("Exception found in doesUserExist method() "+ex);
        }
        return null;
    }
    
    public int getUserId(String emailId){
        try{
            if(con!=null){
                Statement stmt = con.createStatement();
                ResultSet rset= stmt.executeQuery("select user_id from user where email_id='"+emailId+"'");
                if(rset.next()){
                   int id= rset.getInt(1);
                   rset.close();
                   stmt.close();
                   return id;
                }
                else{
                    rset.close();
                    stmt.close();
                    return 0;
                }
            }
        }
        catch(Exception ex){
            System.out.println("Exception occur while getting User Id "+ex);
        }
        return 0;
    }
}
