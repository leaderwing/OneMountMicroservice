package com.quynx.microservice.logsModule.rest.logs.services;

import com.quynx.microservice.logsModule.rest.logs.repositories.ActivityRepository;
import com.quynx.microservice.logsModule.rest.logs.services.impl.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @Autowired
    @InjectMocks
    private ActivityService roleService = new ActivityService();



}
