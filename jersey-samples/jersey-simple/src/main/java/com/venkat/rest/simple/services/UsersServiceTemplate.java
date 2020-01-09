package com.venkat.rest.simple.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.exceptions.JSONWebApplicationException;
import com.venkat.rest.simple.exceptions.ServiceErrorCode;

public class UsersServiceTemplate<U extends User> {

    private List<U> usersList;

    public UsersServiceTemplate() {
        usersList = new ArrayList<>();
    }

    private Optional<U> _filterUsersListById(String userId) {
        return usersList
                   .stream()
                   .filter(u -> u.getUserId().equals(userId))
                   .findFirst();
    }

    private U _getUserById(String userId) {
        return _filterUsersListById(userId).orElse(null);
    }

    public final List<U> getUsers() {
        return Collections.unmodifiableList(usersList);
    }

    public synchronized final U getUserById(String userId) {
        return _filterUsersListById(userId)
                   .orElseThrow(() -> new JSONWebApplicationException(ServiceErrorCode.USER_ID_NOT_FOUND));
    }

    public synchronized final int addUser(final U user) {
        if (user == null) {
            throw new IllegalArgumentException("user parameter is null!");
        } else if (_getUserById(user.getUserId()) != null) {
            throw new JSONWebApplicationException(ServiceErrorCode.USER_ID_EXISTS);
        }
        usersList.add(user);
        return usersList.size();
    }

}
