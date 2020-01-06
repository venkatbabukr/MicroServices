package com.venkat.rest.simple.dto;

public class UserAddResponse {

    int totalUsers;

    public UserAddResponse() { }

    public UserAddResponse(int total) {
        this.totalUsers = total;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int total) {
        this.totalUsers = total;
    }

}
