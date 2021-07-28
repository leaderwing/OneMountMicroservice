package com.quynx.microservice.usersModule.rest.users.repositories;

import com.quynx.microservice.usersModule.rest.users.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
