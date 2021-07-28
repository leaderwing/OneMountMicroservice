package com.quynx.microservice.logsModule.rest.controller;

import com.quynx.microservice.logsModule.rest.logs.dtos.UserListLoginDTO;
import com.quynx.microservice.logsModule.rest.logs.dtos.UserLoginDTO;
import com.quynx.microservice.logsModule.rest.logs.services.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class UserActivityRestController {

    @Autowired
    private IActivityService activityService;

    @PostMapping("/userloginAct")
    public ResponseEntity<?> updatePermission(@RequestBody UserLoginDTO userLoginDTO) {
        activityService.saveLoginLogs(userLoginDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<UserListLoginDTO> getUserActivity()
    {
        List<UserLoginDTO> userLoginDTOS = activityService.getAllUsersActivity();
        UserListLoginDTO userListDTO = new UserListLoginDTO();
        userLoginDTOS.stream().forEach(e -> userListDTO.getUserList().add(e));
        return ResponseEntity.ok(userListDTO);
    }


}
