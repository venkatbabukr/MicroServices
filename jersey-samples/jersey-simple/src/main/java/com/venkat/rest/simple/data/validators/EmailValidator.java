package com.venkat.rest.simple.data.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

    private static final String VALID_EMAIL_REGEX = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(VALID_EMAIL_REGEX);
    }

}
