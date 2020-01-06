package com.venkat.rest.simple.services.v1;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.Sex;
import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.UserAddResponse;

@Path(UserService.BASE_PATH)
public class UserService {

    private final List<User> users;

    public static final String BASE_PATH = "/users";

    public UserService() {
        users = new ArrayList<>();

        // Seed with some data...
        users.add(new User("user1", "Venkat", "Test1", "venkat1@test.com", 35, Sex.MALE));
        users.add(new User("user2", "Venkat", "Test2", "venkat2@test.com", 38, Sex.MALE));
        users.add(new User("user3", "Alice", "Turner", "alice@wonderland.com", 28, Sex.FEMALE));
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
    	return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // TODO: Need to add validations and exceptions...
    public UserAddResponse addUser(User newUser) {
        users.add(newUser);
        return new UserAddResponse(users.size());
    }

}
