package com.quynx.microservice.usersModule.rest.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quynx.microservice.usersModule.rest.users.dtos.UserDTO;
import com.quynx.microservice.usersModule.rest.users.entities.User;
import com.quynx.microservice.usersModule.rest.users.services.impl.UserService;
import com.quynx.microservice.usersModule.rest.users.services.UserTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerIntegrationTest {

    final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserPresentationList() throws Exception {
        UserDTO user1 = new UserDTO(UserTestHelper.getUserTestData(1L, "quy1", "quy11",
                "quy111", "quy1@gmail.com", "+1"));
        UserDTO user2 = new UserDTO(UserTestHelper.getUserTestData(2L, "quy2", "quy22",
                "quy222", "quy2@gmail.com", "+2"));
        UserDTO user3 = new UserDTO(UserTestHelper.getUserTestData(3L, "quy3", "quy33",
                "quy333", "quy3@gmail.com", "+3"));

        List<UserDTO> userList = Arrays.asList(user1, user2, user3);

        given(userService.getUserPresentationList()).willReturn(userList);

        mvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userList[0].name").value("quy11"))
                .andExpect(jsonPath("$.userList[0].surname").value("quy111"))
                .andExpect(jsonPath("$.userList[0].contactDTO.email").value("quy1@gmail.com"))
                .andExpect(jsonPath("$.userList[0].username").value("quy1"))
                .andExpect(jsonPath("$.userList[0].contactDTO.phone").value("+1"))
                .andExpect(jsonPath("$.userList[1].name").value("quy22"))
                .andExpect(jsonPath("$.userList[1].surname").value("quy222"))
                .andExpect(jsonPath("$.userList[1].contactDTO.email").value("quy2@gmail.com"))
                .andExpect(jsonPath("$.userList[1].username").value("quy2"))
                .andExpect(jsonPath("$.userList[1].contactDTO.phone").value("+2"))
                .andExpect(jsonPath("$.userList[2].name").value("quy33"))
                .andExpect(jsonPath("$.userList[2].surname").value("quy333"))
                .andExpect(jsonPath("$.userList[2].contactDTO.email").value("quy3@gmail.com"))
                .andExpect(jsonPath("$.userList[2].username").value("quy3"))
                .andExpect(jsonPath("$.userList[2].contactDTO.phone").value("+3"));
    }

    @Test
    public void getUserById() throws Exception {
        User user1 = UserTestHelper.getUserTestData(1L, "Quynx", "Quy",
                "ngo", "quynx.test@gmail.com", "+8401212121212");

        user1.setBirthDate(LocalDate.of(1993, 5, 11));

        given(userService.getUserById(1L)).willReturn(user1);

        Long userId = 1L;

        mvc.perform(MockMvcRequestBuilders.get("/users/" + userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("name").value("Quy"))
                .andExpect(jsonPath("surname").value("ngo"))
                .andExpect(jsonPath("contactDTO.email").value("quynx.test@gmail.com"))
                .andExpect(jsonPath("username").value("Quynx"))
                .andExpect(jsonPath("birthDate").value("1993-05-11"))
                .andExpect(jsonPath("contactDTO.phone").value("+8401212121212"));
    }

}
