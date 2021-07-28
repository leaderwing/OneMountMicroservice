package com.quynx.microservice.logsModule.rest.logs.services.impl;

import com.quynx.microservice.logsModule.rest.logs.dtos.UserLoginDTO;

import com.quynx.microservice.logsModule.rest.logs.entities.UserActivity;
import com.quynx.microservice.logsModule.rest.logs.repositories.ActivityRepository;
import com.quynx.microservice.logsModule.rest.logs.services.IActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ActivityService implements IActivityService {
    private  static  String LOGIN_ACT = "LOGIN";

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public void saveLoginLogs(UserLoginDTO userLoginDTO) {
        UserActivity user = new UserActivity();
        user.setAction(LOGIN_ACT);
        user.setUser_id(userLoginDTO.getUserId());
        user.setUser_name(userLoginDTO.getUserName());
        user.setLoginTime(userLoginDTO.getLoginTime());
        activityRepository.save(user);
    }
    public List<UserLoginDTO> getAllUsersActivity() {
        ArrayList<UserLoginDTO> userLoginDTOS = new ArrayList<>();
        Iterable<UserActivity> list = getUserList();
        list.forEach(e -> userLoginDTOS.add(new UserLoginDTO(e)));
        return userLoginDTOS;
    }

    public Iterable<UserActivity> getUserList() {
        return activityRepository.findAll();
    }


}
