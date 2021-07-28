package com.quynx.microservice.usersModule.rest.users.services;

import com.quynx.microservice.usersModule.rest.users.dtos.UserDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.requests.CreateOrUpdateUserDTO;
import com.quynx.microservice.usersModule.rest.users.dtos.requests.RegisterUserAccountDTO;
import com.quynx.microservice.usersModule.rest.users.entities.Address;
import com.quynx.microservice.usersModule.rest.users.entities.Contact;
import com.quynx.microservice.usersModule.rest.users.entities.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getUserPresentationList();

    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public User getUserByEmail(String email);

    public User registerUserAccount(RegisterUserAccountDTO registerUserAccountDTO);

    public void checkIfUsernameNotUsed(String username);

    public void checkIfEmailNotUsed(String email);

    public User createUser(CreateOrUpdateUserDTO createUserDTO);

    public void addContactOnUser(User user, Contact contact);

    public void addAddressOnUser(User user, Address address);

    public void addUserRole(User user, long roleId);

    public User updateUser(Long id, CreateOrUpdateUserDTO updateUserDTO);

    public void deleteUserById(Long id);

    public User login(String username, String password);

    public User addRole(Long id, Long roleId);

    public User removeRole(Long id, Long roleId);
}
