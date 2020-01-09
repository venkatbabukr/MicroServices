package com.venkat.rest.simple.resources;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.venkat.rest.simple.resources.v1.UsersResource;
import com.venkat.rest.simple.services.UsersServiceV1;

@Path(ResourcesV1.RESOURCE_BASE_PATH)
public class ResourcesV1 {

    public static final String RESOURCE_BASE_PATH = "/v1";

    @Inject
    private UsersServiceV1 usersSvcV1;

    @Path(UsersResourceTemplate.RESOURCE_BASE_PATH)
    public UsersResource getUserService() {
        return new UsersResource(usersSvcV1);
    }

}
