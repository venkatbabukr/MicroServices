package com.venkat.rest.simple.services.v2;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.data.Sex;

public class UserService {

    private final List<ExtendedUser> users;

    public static final String BASE_PATH = "/users";

    public UserService() {
        users = new ArrayList<>();

        // Seed with some data...
        users.add(new ExtendedUser("user1", "Venkat", "Test1", "venkat1@test.com", 35, Sex.MALE, "Addr1", "+1-605-699-4954"));
        users.add(new ExtendedUser("user2", "Venkat", "Test2", "venkat2@test.com", 38, Sex.MALE, "Addr2", "+1-702-699-4957"));
        users.add(new ExtendedUser("user3", "Alice", "Turner", "alice@wonderland.com", 28, Sex.FEMALE, "Addr3", "+1-453-699-3845"));
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExtendedUser> getUsers() {
    	return users;
    }

}
