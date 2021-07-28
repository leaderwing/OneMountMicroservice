package com.quynx.microservice.usersModule.rest.users.exceptions;

public class PermissionInUseException extends RuntimeException {

    public PermissionInUseException(String message) {
        super(message);
    }

}
