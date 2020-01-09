package com.venkat.rest.simple.dto;

public class ExceptionDetailsResponse {

    private String message;

    public ExceptionDetailsResponse(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

}
