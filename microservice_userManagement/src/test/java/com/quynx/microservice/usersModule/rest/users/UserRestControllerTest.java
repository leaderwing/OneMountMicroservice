package com.quynx.microservice.usersModule.rest.users;

import com.quynx.microservice.usersModule.rest.users.dtos.AddressDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.ContactDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.UserDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.requests.CreateOrUpdateUserDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.requests.RegisterUserAccountDTO;
import com.quynx.microservice.usersModule.rest.users.entities.Role;
import com.quynx.microservice.usersModule.rest.users.entities.User;
import com.quynx.microservice.usersModule.rest.users.repositories.UserRepository;
import com.quynx.microservice.usersModule.rest.users.services.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;



    @Test
    public void test_updateUser() {
        // create a new user to update
        RegisterUserAccountDTO quickAccount = RegisterUserAccountDTO.builder()
                .username("quynx3")
                .password("Quynx!123")
                .name("Quy")
                .surname("Ngo")
                .gender("MALE")
                .email("quynx1@gmail.com")
                .build();

        String registerAccountURL = "/users/register";
        HttpEntity<RegisterUserAccountDTO> requestCreate = new HttpEntity<>(quickAccount);
        ResponseEntity<UserDTO> responseCreate = restTemplate.postForEntity(registerAccountURL, requestCreate, UserDTO.class);

        assertThat(responseCreate.getStatusCode(), equalTo(HttpStatus.CREATED));
        UserDTO userDTO = responseCreate.getBody();

        assertNotNull(userDTO);

        // test the update
        Long userId = userDTO.getId();
        URI uri = URI.create("/users/" + userId);

        CreateOrUpdateUserDTO createOrUpdateUserDTO = CreateOrUpdateUserDTO.builder()
                .username("quynx4")
                .password("Quynx!123456")
                .name("Quy")
                .surname("Ngo")
                .gender("MALE")
                .enabled(true)
                .note("updated for test")
                .email("quynx1@gmail.com")
                .phone("+123123123")
                .skype("skype").facebook("facebook").linkedin("linkedin").website("www.test.com").contactNote("Test on contact")
                .address("CT2B")
                .address2("Thach Ban")
                .city("HN")
                .country("VN")
                .zipCode("111111").build();

        HttpEntity<CreateOrUpdateUserDTO> request = new HttpEntity<>(createOrUpdateUserDTO);
        ResponseEntity<UserDTO> response = restTemplate.exchange(uri, HttpMethod.PUT, request, UserDTO.class);

        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

        UserDTO userUpdatedDTO = response.getBody();

        assertEquals("quynx4", userUpdatedDTO.getUsername());
        assertEquals("Quy", userUpdatedDTO.getName());
        assertEquals("Ngo", userUpdatedDTO.getSurname());
        assertEquals("MALE", userUpdatedDTO.getGender());
        assertEquals(true, userUpdatedDTO.isEnabled());

        // role
        assertNotNull(userUpdatedDTO.getRoles());
        assertTrue(userUpdatedDTO.getRoles().contains( "USER"));

        assertEquals("updated for test", userUpdatedDTO.getNote());

        // contact
        ContactDTO contactDTO = userUpdatedDTO.getContactDTO();
        assertNotNull(contactDTO);

        assertEquals("quynx1@gmail.com", contactDTO.getEmail());
        assertEquals("+123123123", contactDTO.getPhone());
        assertEquals("skype", contactDTO.getSkype());
        assertEquals("facebook", contactDTO.getFacebook());
        assertEquals("linkedin", contactDTO.getLinkedin());
        assertEquals("www.test.com", contactDTO.getWebsite());
        assertEquals("Test on contact", contactDTO.getContactNote());

        // address
        assertNotNull(userUpdatedDTO.getAddressDTO());
        assertEquals("CT2B", userUpdatedDTO.getAddressDTO().getAddress());
        assertEquals("Thach Ban", userUpdatedDTO.getAddressDTO().getAddress2());
        assertEquals("HN", userUpdatedDTO.getAddressDTO().getCity());
        assertEquals("VN", userUpdatedDTO.getAddressDTO().getCountry());
        assertEquals("111111", userUpdatedDTO.getAddressDTO().getZipCode());

        // delete the user
        userService.deleteUserById(userUpdatedDTO.getId());
    }

    @Test
    public void test_deleteUser() {
        // create a new user to test the deletion
        RegisterUserAccountDTO quickAccount = RegisterUserAccountDTO.builder()
                .username("quynx5")
                .password("Quynx1!123")
                .name("quynx1")
                .surname("Ngo")
                .gender("MALE")
                .email("quynx1@gmail.com")
                .build();

        String registerAccountURL = "/users/register";
        HttpEntity<RegisterUserAccountDTO> request = new HttpEntity<>(quickAccount);
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(registerAccountURL, request, UserDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        UserDTO userDTO = response.getBody();

        assertNotNull(userDTO);

        // call the delete endpoint
        String deleteUserURL = "/users/" + userDTO.getId();
        restTemplate.delete(deleteUserURL);

        // retrieve a not existing user must to be empty response
        Optional<User> userOpt = userRepository.findById(userDTO.getId());
        assertFalse(userOpt.isPresent());
    }





}
