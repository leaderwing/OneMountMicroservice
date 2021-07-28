package com.quynx.microservice.usersModule.rest.users.exceptions;

public class UserIsSecuredException extends RuntimeException {

    public UserIsSecuredException(String message) {
        super(message);
    }

}
