package com.venkat.rest.simple.services;

import com.venkat.rest.simple.data.ExtendedUser;
import com.venkat.rest.simple.data.Sex;

public class UsersServiceV2 extends UsersServiceTemplate<ExtendedUser> {

    public UsersServiceV2() {
        // Seed with some data...
        addUser(new ExtendedUser("user1", "Venkat", "Test1", "venkat1@test.com", 35, Sex.MALE, "Addr1", "+1-605-699-4954"));
        addUser(new ExtendedUser("user2", "Venkat", "Test2", "venkat2@test.com", 38, Sex.MALE, "Addr2", "+1-702-699-4957"));
        addUser(new ExtendedUser("user3", "Alice", "Turner", "alice@wonderland.com", 28, Sex.FEMALE, "Addr3", "+1-453-699-3845"));
    }

}
