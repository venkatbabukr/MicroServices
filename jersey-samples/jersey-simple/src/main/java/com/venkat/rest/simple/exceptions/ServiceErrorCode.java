package com.venkat.rest.simple.exceptions;

import javax.ws.rs.core.Response.Status;

import com.venkat.rest.simple.dto.out.ExceptionDetailsResponse;

public enum ServiceErrorCode {
    USER_ID_EXISTS(Status.CONFLICT, "com.venkat.rest.simple.services.UsersService.addUser.conflict"),
    USER_ID_NOT_FOUND(Status.NOT_FOUND, "com.venkat.rest.simple.services.UsersService.userNotFound");

    private Status responseStatus;

    private String errorMsgCode;

    private ServiceErrorCode(Status status, String msgCode) {
        responseStatus = status;
        errorMsgCode = msgCode;
    }

    public Status getResponseStatus() {
        return responseStatus;
    }

    public String getErrorMsgCode() {
        return errorMsgCode;
    }

    public ExceptionDetailsResponse getExceptionDetailsResponse() {
        String exceptionMessage = ExceptionMessageProvider.INSTANCE.getMessage(errorMsgCode);
        return new ExceptionDetailsResponse(exceptionMessage);
    }

}
