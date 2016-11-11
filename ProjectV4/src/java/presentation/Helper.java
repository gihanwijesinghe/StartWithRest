/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import entity.UserTab;
//import java.sql.Connection;
//import java.sql.DriverManager;
import javax.persistence.EntityManager;
import java.sql.*;
import javax.sql.*;

/**
 *
 * @author Gihan
 */

public class Helper {
    public int readValidation(UserTab user){
        if(user.getReadvalidation().equals("Y")){
            return 10;
        }
        return 100;
    }
    
    public int createValidation(UserTab user){
        if(user.getCreatevalidation().equals("Y")){
            return 10;
        }
        return 100;
    }
    
    public int modifyValidation(UserTab user){
        if(user.getModifyvalidation().equals("Y")){
            return 10;
        }
        return 100;
    }
    
    public int loginValidation(UserTab user, String password){
//        if(user.getUserPwd().equals(password)){
//            return 1;
//        }
        String username = user.getUserName();
        //username = "";
        System.out.println(username+password);
        try{

            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?" , username, password); 
 
            if(conn != null){   
                   return 1;
//            out.println(username);
//            out.println("<a href='create_user.jsp'>create_user</a>");
       
            }   
        }
            catch(Exception e){
                System.out.println("Exception throws");
                return 0;
                //out.println("Invalid password <a href='index.jsp'>try again</a>");       
            } 
        System.out.println("connection doesn't happen at all");
        return 0;
    }
    
//    public int loginValidation(User user, String password){
//        if(user.getUserPwd().equals(password)){
//            return 1;
//        }
//        return 0;
//    }
}