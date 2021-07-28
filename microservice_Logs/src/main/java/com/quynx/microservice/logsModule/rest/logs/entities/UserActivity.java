package com.quynx.microservice.logsModule.rest.logs.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_activity")
@Data
@NoArgsConstructor
public class UserActivity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    private Long id;

    @Column(name="action", nullable = false)
    private String action;

    @Column(name="user_id", nullable = false)
    private String user_id;

    @Column(name="user_name", nullable = false)
    private String user_name;

    @Column(name="login_time")
    private LocalDateTime loginTime;



}
