/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.UserTab;
import service.AbstractFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import presentation.Helper;

/**
 *
 * @author Gihan
 */
public abstract class Wrapper<T> extends AbstractFacade<T>{

    public Wrapper(Class<T> entityClass) {
        super(entityClass);
    }

//    private Class<T> entityClass;
    Helper helper = new Helper();

//    public WrapperNew(Class<T> entityClass) {
//        this.entityClass = entityClass;
//    }

//    protected EntityManager getEntityManager();

    public void createNew(T entity) {
        //getEntityManager().persist(entity);
        super.create(entity);
    }
    
    public void deleteNew(T entity){
        super.remove(entity);
    }
    
    /*Testing method for get user xml or json version*/
    public T getDataUser(Object id) {
        T t = find(id);
        if(helper.readValidation((UserTab)t) == 10){
            return super.find(id);
//            return getEntityManager().find(entityClass, id);
        }
        else{
            return (T)"You don't have authentication";           
        }
    }
    
    /*Reading data for a given user*/
    public String readDataNew(String id) {
        T t = findNew(id);
        UserTab user = new UserTab();
        try{
            user = (UserTab)t;
            if(helper.readValidation(user) == 10){            
                return printStreamNew(user);
            }
            else{
                return "You don't have authentication";           
            }
        }
        catch(Exception e){
            return "User ID is not correct, Please enter a correct one";
        }
    }
    
    /*Printing User object's data in plain text*/
    public String printStreamNew(UserTab user){
        String s;
        StringBuilder sb = new StringBuilder();
            //s = user.getUserPwd();
            sb.append("User ID = ").append(user.getUserId()).append("\n");
            sb.append("User Name = ").append(user.getUserName()).append("\n");
            sb.append("User Password = ").append(user.getUserPwd());
        s = sb.toString();
        return s;
    }
    
    /*user login method, returning which page to map*/
    public Response userLoginNew(String username, String password){
        T t = find(username);
        UserTab user = new UserTab();
        try{
            user = (UserTab)t;
            if(helper.loginValidation(user, password) == 1){  //Checking the validations of user          
                java.net.URI location = new java.net.URI("../readData.jsp");
                return Response.temporaryRedirect(location).build();
            }
            else{
                String error = "Password Incorrect";
                return Response.ok(error).build();          
            }  
        }
        catch(Exception e){
            String error = "Username incorrect, Please try again";
            return Response.ok(error).build();
        }
    }

    public T findNew(Object id) {
        //return getEntityManager().find(entityClass, id);
        System.out.println("goodwork");
        return super.find(id);
    }

    public int countNew() {
        return super.count();
    }
    
}
