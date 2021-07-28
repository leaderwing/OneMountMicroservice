package com.quynx.microservice.usersModule.rest.api;

import com.quynx.microservice.usersModule.rest.users.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CallLogsService {

    public  static  final  String URL_API_LOGS = "http://localhost:8091";

    public void sendUserLoginAct(UserDTO userDTO) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL_API_LOGS +"/logs/userloginAct", userDTO, UserDTO.class);
    }
}
