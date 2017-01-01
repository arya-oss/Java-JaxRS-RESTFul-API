package com.rahackya.restapp.api;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rahackya.restapp.dao.UserDao;
import com.rahackya.restapp.model.User;
import org.apache.log4j.Logger;

/**
 * Created by Rajmani on 12/29/16.
 */

@Path("/api")
public class UserService {
    private final static Logger logger = Logger.getLogger(UserService.class);
    private final UserDao userDao = UserDao.getInstance();
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response index() {
        logger.info("Index resourece requested");
        return Response.status(200).entity("REST API v1 by Rajmani Arya").build();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAll() {
        logger.info("All user requested");
        List<User> output = userDao.getAll();
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Integer id) {
        logger.info("User with " + id + " requested");
        User output = userDao.get(id);
        if (output == null) {
        	return Response.status(404).entity(output).build();
        } else {
        	return Response.status(200).entity(output).build();
        }
    }

    @POST
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN)
    public Response add( @FormParam("rollno") int rollno,
                         @FormParam("name") String name,
                         @FormParam("email") String email,
                         @FormParam("phone") String phone,
                         @FormParam("company") String company
                         ) {
        logger.info("Adding new User " + name);
        User user = new User();
        user.setRollno(rollno);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCompany(company);
        if (userDao.add(user)) {
            return Response.status(201).entity("User Created").build();
        } else {
            return Response.status(403).entity("Provide all form data").build();
        }
    }

    @PUT
    @Path("/users/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response add( @PathParam("id") Integer id,
                         @FormParam("rollno") int rollno,
                         @FormParam("name") String name,
                         @FormParam("email") String email,
                         @FormParam("phone") String phone,
                         @FormParam("company") String company
                         ) {
        logger.info("Updating user " + id);
        User user = new User();
        user.setRollno(rollno);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCompany(company);
        if (userDao.update(id, user)) {
            return Response.status(200).entity("User Updated").build();
        } else {
            return Response.status(404).entity("User not found").build();
        }
    }

    @DELETE
    @Path("/users/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response destroy(@PathParam("id") Integer id) {
        logger.info("Destroy user " + id);
        if (userDao.destroy(id)) {
            return Response.status(200).entity("User Deleted").build();
        } else {
            return Response.status(404).entity("User doesn't exist.").build();
        }
    }

}
