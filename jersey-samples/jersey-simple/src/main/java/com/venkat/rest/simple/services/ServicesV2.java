package com.venkat.rest.simple.services;

import javax.ws.rs.Path;

import com.venkat.rest.simple.services.v2.UserService;

@Path(ServicesV2.BASE_PATH)
public class ServicesV2 {

    public static final String BASE_PATH = "/v2";

	@Path(UserService.BASE_PATH)
    public UserService getUserService() {
    	return new UserService();
    }

}
