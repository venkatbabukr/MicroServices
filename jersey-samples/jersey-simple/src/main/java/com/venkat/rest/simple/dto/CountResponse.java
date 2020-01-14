package com.venkat.rest.simple.dto;

public class CountResponse {

    int totalCount;

    public CountResponse() { }

    public CountResponse(int total) {
        this.totalCount = total;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int total) {
        this.totalCount = total;
    }

}
