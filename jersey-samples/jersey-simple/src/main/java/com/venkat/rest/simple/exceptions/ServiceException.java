package com.venkat.rest.simple.exceptions;

public class ServiceException extends RuntimeException {

    /** Default serialVersionUID */
    private static final long serialVersionUID = 1L;

    private ServiceErrorCode code;

    public ServiceException(ServiceErrorCode code) {
        super(code.getErrorMessage());
        this.code = code;
    }

    public ServiceErrorCode getServiceErrorCode() {
        return code;
    }

}
