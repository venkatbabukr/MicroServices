package com.venkat.rest.simple.data;

public interface UserSearchCriteria<U extends User> {

    boolean equals(U user);

}
