package com.venkat.rest.simple.resources.v2;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.dto.in.ExtendedUserDI;
import com.venkat.rest.simple.dto.out.SearchResponse;
import com.venkat.rest.simple.resources.UsersResourceTemplate;
import com.venkat.rest.simple.services.UsersServiceV2;

public class UsersResource extends UsersResourceTemplate<ExtendedUser, ExtendedUserDI<ExtendedUser>, UsersServiceV2> {

    public UsersResource(UsersServiceV2 service) {
        super(service);
    }

    @GET
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final SearchResponse<ExtendedUser> searchUsersGet(@BeanParam ExtendedUserDI<ExtendedUser> searchReq) {
        return super.searchUsers(searchReq);
    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final SearchResponse<ExtendedUser> searchUsersPost(ExtendedUserDI<ExtendedUser> searchReq) {
        return super.searchUsers(searchReq);
    }

}
