package com.quynx.microservice.usersModule.rest.controller;

import com.quynx.microservice.usersModule.rest.users.dtos.UserDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.requests.LoginRequestDTO;
import com.quynx.microservice.usersModule.rest.users.entities.User;
import com.quynx.microservice.usersModule.rest.users.services.IUserService;
import com.quynx.microservice.usersModule.rest.users.services.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
@Slf4j
public class LoginRestController {

    @Autowired
    private IUserService userService;

    public LoginRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = userService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(new UserDTO(user));
    }

}
