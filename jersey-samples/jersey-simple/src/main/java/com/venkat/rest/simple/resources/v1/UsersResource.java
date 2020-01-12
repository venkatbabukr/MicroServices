package com.venkat.rest.simple.resources.v1;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.UserSearchRequest;
import com.venkat.rest.simple.resources.UsersResourceTemplate;
import com.venkat.rest.simple.services.UsersServiceV1;

@Path(UsersResourceTemplate.RESOURCE_BASE_PATH)
public class UsersResource extends UsersResourceTemplate<User, UsersServiceV1> {

    @Inject
    public UsersResource(UsersServiceV1 service) {
        super(service);
    }

    @GET
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final List<User> searchUsersGet(@BeanParam UserSearchRequest<User> searchReq) {
        return getUsersService().searchUsers(searchReq);
    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final List<User> searchUsersPost(UserSearchRequest<User> searchReq) {
        return getUsersService().searchUsers(searchReq);
    }

}
