/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import models.User;

/**
 *
 * @author manish
 */
public class UserDAO {
    //registering
    public void addUser(User user){
    
        //fetch roll_id
          //check whether the same person exist with same email id
          //if yes then show error
          //or otherwise add him and show a msg of added.
          
          
          
    }
    //for logging in
    public User getUserByIdAndRole(String id, String role){
        return new User(); 
    }
    
}
