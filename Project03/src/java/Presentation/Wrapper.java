/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gihan
 */
public abstract class Wrapper<T> {

    private Class<T> entityClass;
    Helper helper = new Helper();

    public Wrapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    /*Testing method for get user xml or json version*/
    public T getDataUser(Object id) {
        T t = find(id);
        if(helper.readValidation((User)t) == 10){
            return getEntityManager().find(entityClass, id);
        }
        else{
            return (T)"You don't have authentication";           
        }
    }
    
    /*Reading data for a given user*/
    public String readData(String id) {
        T t = find(id);
        User user = new User();
        try{
            user = (User)t;
            if(helper.readValidation(user) == 10){            
                return printStream(user);
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
    public String printStream(User user){
        String s;
        StringBuilder sb = new StringBuilder();
            //s = user.getUserPwd();
            sb.append("User ID = ").append(user.getUserID()).append("\n");
            sb.append("User Name = ").append(user.getUserName()).append("\n");
            sb.append("User Password = ").append(user.getUserPwd());
        s = sb.toString();
        return s;
    }
    
    /*user login method, returning which page to map*/
    public Response userLogin(String username, String password){
        T t = find(username);
        User user = new User();
        try{
            user = (User)t;
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
    
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}