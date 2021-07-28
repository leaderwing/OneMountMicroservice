package com.quynx.microservice.logsModule.rest.logs.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserListLoginDTO implements java.io.Serializable {

    private ArrayList<UserLoginDTO> userList;

    public UserListLoginDTO() {
        userList = new ArrayList<>();
    }

}
