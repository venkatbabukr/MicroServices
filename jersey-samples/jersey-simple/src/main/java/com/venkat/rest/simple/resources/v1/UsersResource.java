package com.venkat.rest.simple.resources.v1;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.SearchResponse;
import com.venkat.rest.simple.dto.UserSearchCriteria;
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
    public final SearchResponse<User> searchUsersGet(@BeanParam UserSearchCriteria<User> searchReq) {
        return super.searchUsers(searchReq);
    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final SearchResponse<User> searchUsersPost(UserSearchCriteria<User> searchReq) {
        return super.searchUsers(searchReq);
    }

}
