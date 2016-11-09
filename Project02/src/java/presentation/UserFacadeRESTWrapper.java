/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.User;
import java.net.URI;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Gihan
 */
@Stateless
@Path("entity.userpresentation")
public class UserFacadeRESTWrapper extends Wrapper<User> {

    @PersistenceContext(unitName = "Project02PU")
    private EntityManager em;

    public UserFacadeRESTWrapper() {
        super(User.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }
    
    @POST
    @Path("/Postme")
    @Produces("text/plain")
    public Response getData1(@FormParam("user")String user)
    {
        return Response.ok(user).build();
    }
    
    @POST
    @Path("/Postme/readData")
    @Produces("text/plain")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String readData(@FormParam("user")Integer id)
    {
        return super.readData(id);
    }
    
    @POST
    @Path("addUser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addUser(@FormParam("username") String username) throws URISyntaxException{
        java.net.URI location = new java.net.URI("../index.html");
        return Response.temporaryRedirect(location).build();
    }
    
    @POST
    @Path("switchTOHome")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response switchToHome(@FormParam("username") String username, @FormParam("password") String password) throws URISyntaxException{
//        int i = super.userLogin(username, password);
//        if(i == 1){
//            java.net.URI location = new java.net.URI("../readData.jsp");
//            return Response.temporaryRedirect(location).build();
//        }
        String error = "Login Failed";
        return Response.ok(error).build();
//        return super.userLogin(username, password);
    }
    
//    @POST
//    @Path("switchTOHome")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response switchToHome(@FormParam("username") String username, @FormParam("password") String password) throws URISyntaxException{
//        int i = super.userLogin(username, password);
//        if(i == 1){
//            java.net.URI location = new java.net.URI("../readData.jsp");
//            return Response.temporaryRedirect(location).build();
//        }
//        String error = "Login Failed";
//        return Response.ok(error).build();
//    }
    
    @POST
    @Path("testing1")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response addUsernew(@FormParam("user") String name,@FormParam("age") String age){
        return Response.status(200).entity("addUser is called, name : " + name + ", age : " + age).build();
    }    


    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("getDataUser/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object getDataUser(@PathParam("id") Integer id) {
        return (Object)super.getDataUser(id);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
