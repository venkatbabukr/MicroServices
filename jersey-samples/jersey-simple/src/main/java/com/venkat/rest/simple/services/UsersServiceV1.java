package com.venkat.rest.simple.services;

import com.venkat.rest.simple.data.Sex;
import com.venkat.rest.simple.data.User;

public class UsersServiceV1 extends UsersServiceTemplate<User> {

    public UsersServiceV1() {
        // Seed with some data...
        addUser(new User("user1", "Venkat", "Test1", "venkat1@test.com", 35, Sex.MALE));
        addUser(new User("user2", "Venkat", "Test2", "venkat2@test.com", 38, Sex.MALE));
        addUser(new User("user3", "Alice", "Turner", "alice@wonderland.com", 28, Sex.FEMALE));
    }

}
