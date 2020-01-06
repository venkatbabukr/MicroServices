package com.venkat.rest.simple.services;

import javax.ws.rs.Path;

import com.venkat.rest.simple.services.v1.UserService;

@Path(ServicesV1.BASE_PATH)
public class ServicesV1 {

    public static final String BASE_PATH = "/v1";

	@Path(UserService.BASE_PATH)
    public UserService getUserService() {
    	return new UserService();
    }

}
