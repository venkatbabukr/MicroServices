package com.venkat.rest.simple.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JSONWebApplicationException extends WebApplicationException {

    /** Default serialVersionUID */
    private static final long serialVersionUID = 1L;

    public JSONWebApplicationException(ServiceErrorCode code) {
        super(Response.status(code.getResponseStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(code.getResponseEntity())
                .build());
    }

}
