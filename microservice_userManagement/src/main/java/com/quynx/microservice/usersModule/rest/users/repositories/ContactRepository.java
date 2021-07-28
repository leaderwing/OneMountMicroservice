package com.quynx.microservice.usersModule.rest.users.repositories;

import com.quynx.microservice.usersModule.rest.users.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
