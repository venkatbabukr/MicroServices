package com.venkat.rest.simple.resources;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.in.ISearchInput;
import com.venkat.rest.simple.dto.in.UserDI;
import com.venkat.rest.simple.dto.out.CountResponse;
import com.venkat.rest.simple.dto.out.ListResponse;
import com.venkat.rest.simple.dto.out.SearchResponse;
import com.venkat.rest.simple.services.UsersServiceTemplate;
import com.venkat.rest.simple.validation.ValidationGroups.CreateOperation;
import com.venkat.rest.simple.validation.ValidationGroups.PatchOperation;
import com.venkat.rest.simple.validation.ValidationGroups.UpdateOperation;

public abstract class UsersResourceTemplate<U extends User, UDI extends UserDI<U>, US extends UsersServiceTemplate<U>> {

    public static final String RESOURCE_BASE_PATH = "/users";

    private US usersService;

    public UsersResourceTemplate(US service) {
        this.usersService = service;
    }

    protected final SearchResponse<U> searchUsers(ISearchInput<U> sc) {
        List<U> searchResults = usersService.searchUsers(sc);
        return new SearchResponse<U>(sc, searchResults);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public final ListResponse<U> getUsers() {
        return new ListResponse<U>(usersService.getUsers());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final CountResponse addUser(@NotNull(message = "{com.venkat.rest.simple.userApi.user.required}")
                                       @Valid
                                       @ConvertGroup(from = Default.class, to = CreateOperation.class)
                                       final UDI userInput) {
        int totalUsersCount = usersService.addUser(userInput);
        return new CountResponse(totalUsersCount);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final U getUserById(@PathParam("id") final String userId) {
        return usersService.getUserById(userId);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final U updateUser(@PathParam("id") final String userId,
                                          @NotNull(message = "{com.venkat.rest.simple.userApi.user.required}")
                                          @Valid
                                          @ConvertGroup(from = Default.class, to = UpdateOperation.class)
                                          final UDI updatedUserInput) {
        return usersService.updateUser(userId, updatedUserInput);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final U patchUser(@PathParam("id") final String userId,
                                          @NotNull(message = "{com.venkat.rest.simple.userApi.user.required}")
                                          @Valid
                                          @ConvertGroup(from = Default.class, to = PatchOperation.class)
                                          final UDI patchUserInput) {
        return usersService.patchUser(userId, patchUserInput);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final CountResponse removeUser(@PathParam("id") final String userId) {
        int totalUsersCount = usersService.removeUser(userId);
        return new CountResponse(totalUsersCount);
    }

}
