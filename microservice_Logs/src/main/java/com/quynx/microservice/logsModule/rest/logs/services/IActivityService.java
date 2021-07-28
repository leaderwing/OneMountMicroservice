package com.quynx.microservice.logsModule.rest.logs.services;

import com.quynx.microservice.logsModule.rest.logs.dtos.UserLoginDTO;
import com.quynx.microservice.logsModule.rest.logs.entities.UserActivity;

import java.util.List;


public interface IActivityService {

    public void saveLoginLogs(UserLoginDTO userLoginDTO);

    public List<UserLoginDTO> getAllUsersActivity();

    public Iterable<UserActivity> getUserList();

}
