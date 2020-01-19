package com.venkat.rest.simple.dto.out;

public class ExceptionDetailsResponse {

    private String message;

    public ExceptionDetailsResponse(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

}
