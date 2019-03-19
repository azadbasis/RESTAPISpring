package com.restapi.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 134877110917143560L;

    public UserServiceException(String message) {
        super(message);
    }
}
