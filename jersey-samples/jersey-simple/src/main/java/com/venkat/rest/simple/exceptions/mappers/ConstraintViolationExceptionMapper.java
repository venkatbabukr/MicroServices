package com.venkat.rest.simple.exceptions.mappers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.venkat.rest.simple.dto.ValidationExceptionDetailsResponse;

public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<String> validationErrorMessages = exception.getConstraintViolations()
                                                   .stream()
                                                   .map(cv -> cv.getMessage())
                                                   .collect(Collectors.toList());
        return Response
                   .status(Status.BAD_REQUEST)
                   .type(MediaType.APPLICATION_JSON)
                   .entity(new ValidationExceptionDetailsResponse(validationErrorMessages))
                   .build();
    }

}
