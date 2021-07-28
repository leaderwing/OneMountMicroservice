package com.quynx.microservice.usersModule.rest.users.exceptions;

public class RoleInUseException extends RuntimeException {

    public RoleInUseException(String message) {
        super(message);
    }

}
