package com.venkat.rest.simple.resources;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.SearchCriteria;
import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.CountResponse;
import com.venkat.rest.simple.dto.ListResponse;
import com.venkat.rest.simple.dto.SearchResponse;
import com.venkat.rest.simple.services.UsersServiceTemplate;

public abstract class UsersResourceTemplate<U extends User, US extends UsersServiceTemplate<U>> {

    public static final String RESOURCE_BASE_PATH = "/users";

    private US usersService;

    public UsersResourceTemplate(US service) {
        this.usersService = service;
    }

    protected final SearchResponse<U> searchUsers(SearchCriteria<U> sc) {
        List<U> searchResults = usersService.searchUsers(sc);
        return new SearchResponse<U>(sc, searchResults);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public final ListResponse<U> getUsers() {
        return new ListResponse<U>(usersService.getUsers());
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
    public final CountResponse addUser(@NotNull(message = "{com.venkat.rest.simple.userApi.addUser.user.required}") @Valid final U user) {
        int totalUsersCount = usersService.addUser(user);
        return new CountResponse(totalUsersCount);
    }

}
