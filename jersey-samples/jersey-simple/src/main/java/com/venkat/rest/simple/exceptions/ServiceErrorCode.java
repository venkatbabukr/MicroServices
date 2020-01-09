package com.venkat.rest.simple.exceptions;

import javax.ws.rs.core.Response.Status;

import com.venkat.rest.simple.dto.ExceptionDetailsResponse;

public enum ServiceErrorCode {
    USER_ID_EXISTS(Status.CONFLICT, "User with given userId already exists!"),
    USER_ID_NOT_FOUND(Status.NOT_FOUND, "Not able to find user with given userId");

    private Status responseStatus;

    private String errorMessage;

    private ServiceErrorCode(Status status, String msg) {
        responseStatus = status;
        errorMessage = msg;
    }

    public Status getResponseStatus() {
        return responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ExceptionDetailsResponse getResponseEntity() {
        return new ExceptionDetailsResponse(errorMessage);
    }

}
