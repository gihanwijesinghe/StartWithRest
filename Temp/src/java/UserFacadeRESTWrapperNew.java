/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.User;
import java.net.URISyntaxException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gihan
 */
@Stateless
@Path("presentNew")
public class UserFacadeRESTWrapperNew extends WrapperNew<User> {

    @PersistenceContext(unitName = "Project03PU")
    private EntityManager em;

    public UserFacadeRESTWrapperNew() {
        super(User.class);
    }

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void createNew(User entity) {
//        super.createNew(entity);
//    }
//    
    @POST
    @Path("/Postme/readData")
    @Produces("text/plain")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String readDataNew(@FormParam("user")String username)
    {
        return super.readDataNew(username);
    }
    
    @POST
    @Path("switchTOHome")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response switchToHomeNew(@FormParam("username") String username, @FormParam("password") String password) throws URISyntaxException{
        return super.userLoginNew(username, password);
    }
    @POST
    @Path("checkDelete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void deleteNew(@FormParam("username") String username){
        System.out.println("inside the checkDelete");
        super.deleteNew(super.findNew(username));
    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") String id, User entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void removeNew(@PathParam("id") String id) {
//        super.deleteNew(super.findNew(id));
//    }
//
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User findNew(@PathParam("id") String id) {
        System.out.println("sent to wrappernew class");
        return super.findNew(id);
    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<User> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.countNew());
        //return String.valueOf(super.count());
    }
//    
//    @GET
//    @Path("getDataUser/{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Object getDataUser(@PathParam("id") String id) {
//        return (Object)super.getDataUser(id);
//    }

    @Override
    protected EntityManager getEntityManager() {      
        return em;
    }
    
}
