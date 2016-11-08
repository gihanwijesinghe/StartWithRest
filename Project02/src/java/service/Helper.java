/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.User;
import javax.persistence.EntityManager;

/**
 *
 * @author Gihan
 */
//

/**
 *
 * @author Gihan
 */
public class Helper {
    public int readValidation(User user){
        if(user.getReadValidation().equals("Y")){
            return 10;
        }
        return 100;
    }
    
    public int createValidation(User user){
        if(user.getCreateValidation().equals("Y")){
            return 10;
        }
        return 100;
    }
    
    public int modifyValidation(User user){
        if(user.getModifyValidation().equals("Y")){
            return 10;
        }
        return 100;
    }
}