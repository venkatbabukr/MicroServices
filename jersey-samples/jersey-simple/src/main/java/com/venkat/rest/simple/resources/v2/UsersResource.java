package com.venkat.rest.simple.resources.v2;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.resources.UsersResourceTemplate;
import com.venkat.rest.simple.services.UsersServiceV2;

public class UsersResource extends UsersResourceTemplate<ExtendedUser, UsersServiceV2> {

    public UsersResource(UsersServiceV2 service) {
        super(service);
    }

}
