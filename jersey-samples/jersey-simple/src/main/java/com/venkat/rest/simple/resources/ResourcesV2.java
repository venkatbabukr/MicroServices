package com.venkat.rest.simple.resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.resources.v2.UsersResource;
import com.venkat.rest.simple.services.UsersServiceV2;

@Path(ResourcesV2.RESOURCE_BASE_PATH)
public class ResourcesV2 {

    public static final String RESOURCE_BASE_PATH = "/v2";

    @Inject
    private UsersServiceV2 usersSvcV2;

    @Path(UsersResourceTemplate.RESOURCE_BASE_PATH)
    public UsersResource getUserService() {
        return new UsersResource(usersSvcV2);
    }

    /*
     * TODO: We can also do this perhaps...
     *
    @Path(UsersResourceTemplate.BASE_PATH)
    public UsersResourceTemplate<ExtendedUser, UsersServiceV2> getUserService() {
        return new UsersResourceTemplate<ExtendedUser, UsersServiceV2>(usersService) { };
    }
     */

}
