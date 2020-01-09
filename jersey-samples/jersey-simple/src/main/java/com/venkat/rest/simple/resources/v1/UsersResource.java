package com.venkat.rest.simple.resources.v1;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.resources.UsersResourceTemplate;
import com.venkat.rest.simple.services.UsersServiceV1;

@Path(UsersResourceTemplate.RESOURCE_BASE_PATH)
public class UsersResource extends UsersResourceTemplate<User, UsersServiceV1> {

    @Inject
    public UsersResource(UsersServiceV1 service) {
        super(service);
    }

}
