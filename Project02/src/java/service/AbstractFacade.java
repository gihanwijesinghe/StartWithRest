/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gihan
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;
    Helper helper = new Helper();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    public T getDataUser(Object id) {
        T t = find(id);
        if(helper.readValidation((User)t) == 10){
            return getEntityManager().find(entityClass, id);
        }
        else{
            return (T)"You don't have authentication";           
        }
    }
    
    public String readData(Object id) {
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
