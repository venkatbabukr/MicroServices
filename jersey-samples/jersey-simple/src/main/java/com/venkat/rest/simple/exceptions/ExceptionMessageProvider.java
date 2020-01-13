package com.venkat.rest.simple.exceptions;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public final class ExceptionMessageProvider {

    private static final String MESSAGE_BUNDLE_RESOURCE = "ExceptionMessages";

    public static final ExceptionMessageProvider INSTANCE = new ExceptionMessageProvider();

    private ResourceBundle messagesBundle;

    private ExceptionMessageProvider() {
        this.messagesBundle = PropertyResourceBundle.getBundle(MESSAGE_BUNDLE_RESOURCE);
    }

    public String getMessage(String msgCode) {
        return messagesBundle.getString(msgCode);
    }

}
