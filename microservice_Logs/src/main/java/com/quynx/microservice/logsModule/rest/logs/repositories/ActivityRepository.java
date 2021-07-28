package com.quynx.microservice.logsModule.rest.logs.repositories;

import com.quynx.microservice.logsModule.rest.logs.entities.UserActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActivityRepository extends CrudRepository<UserActivity, Long> {

}
