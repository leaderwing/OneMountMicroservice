package com.quynx.microservice.usersModule.rest.users.exceptions;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String message) {
        super(message);
    }

}
