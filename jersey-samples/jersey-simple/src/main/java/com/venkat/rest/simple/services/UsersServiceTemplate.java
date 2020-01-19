package com.venkat.rest.simple.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.venkat.rest.simple.data.User;
import com.venkat.rest.simple.dto.in.ISearchInput;
import com.venkat.rest.simple.dto.in.UserDI;
import com.venkat.rest.simple.exceptions.JSONWebApplicationException;
import com.venkat.rest.simple.exceptions.ServiceErrorCode;

public abstract class UsersServiceTemplate<U extends User> {

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

    protected void addUser(U user) {
        usersList.add(user);
    }

    public final List<U> getUsers() {
        return Collections.unmodifiableList(usersList);
    }

    public synchronized final U getUserById(String userId) {
        return _filterUsersListById(userId)
                   .orElseThrow(() -> new JSONWebApplicationException(ServiceErrorCode.USER_ID_NOT_FOUND));
    }

    public final List<U> searchUsers(ISearchInput<U> sc) {
        return usersList.stream()
                   .filter(u -> sc.matchEntity(u))
                   .collect(Collectors.toList());
    }

    public synchronized final int addUser(final UserDI<U> userInput) {
        if (userInput == null) {
            throw new IllegalArgumentException("user parameter is null!");
        } else if (_getUserById(userInput.getUserId()) != null) {
            throw new JSONWebApplicationException(ServiceErrorCode.USER_ID_EXISTS);
        }
        usersList.add(userInput.toEntity());
        return usersList.size();
    }

    public synchronized final U updateUser(final String userId, final UserDI<U> updatedUserInput) {
        U user = getUserById(userId);
        return updatedUserInput.patchEntity(user, false);
    }

    public synchronized final U patchUser(final String userId, final UserDI<U> patchUserInput) {
        U user = getUserById(userId);
        return patchUserInput.patchEntity(user, true);
    }

    public synchronized final int removeUser(final String userId) {
        int removeIdx = IntStream.range(0, usersList.size())
                            .filter(idx -> usersList.get(idx).getUserId().equals(userId))
                            .findAny()
                            .orElseThrow(() -> new JSONWebApplicationException(ServiceErrorCode.USER_ID_NOT_FOUND));
        usersList.remove(removeIdx);
        return usersList.size();
    }

}
