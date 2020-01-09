package com.venkat.rest.simple.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.UserAddResponse;
import com.venkat.rest.simple.services.UsersServiceTemplate;

public abstract class UsersResourceTemplate<U extends User, US extends UsersServiceTemplate<U>> {

    public static final String RESOURCE_BASE_PATH = "/users";

    private US usersService;

    public UsersResourceTemplate(US service) {
        this.usersService = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public final List<U> getUsers() {
        return usersService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final U getUserById(final @PathParam("id") String userId) {
        return usersService.getUserById(userId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // TODO: Need to add validations and exceptions...
    public final UserAddResponse addUser(final U user) {
        int totalUsersCount = usersService.addUser(user);
        return new UserAddResponse(totalUsersCount);
    }

}
