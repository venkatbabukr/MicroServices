package com.venkat.rest.simple.dto.out;

import java.util.Collections;
import java.util.List;

public class ValidationExceptionDetailsResponse extends ExceptionDetailsResponse {

    private static final String VALIDATION_EXCEPTION_MESSAGE = "There are validation problems!";

    private List<String> validationErrors;

    public ValidationExceptionDetailsResponse(List<String> errors) {
        super(VALIDATION_EXCEPTION_MESSAGE);
        this.validationErrors = Collections.unmodifiableList(errors);
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

}
