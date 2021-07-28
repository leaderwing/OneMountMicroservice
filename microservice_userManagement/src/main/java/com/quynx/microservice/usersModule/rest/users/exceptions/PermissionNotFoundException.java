package com.quynx.microservice.usersModule.rest.users.exceptions;

public class PermissionNotFoundException extends RuntimeException {

    public PermissionNotFoundException(String message) {
        super(message);
    }

}
