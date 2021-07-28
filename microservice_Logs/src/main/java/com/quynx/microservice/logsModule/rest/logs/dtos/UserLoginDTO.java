package com.quynx.microservice.logsModule.rest.logs.dtos;

import com.quynx.microservice.logsModule.rest.logs.entities.UserActivity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class UserLoginDTO implements Serializable {

    private Long id;
    private String action;
    private String userId;
    private String userName;
    private LocalDateTime loginTime;

    public UserLoginDTO(UserActivity user) {
        if (user != null) {
            this.action = user.getAction();
            this.userId = user.getUser_id();
            this.userName = user.getUser_name();
            this.loginTime = user.getLoginTime();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginDTO)) return false;
        return id != null && id.equals(((UserLoginDTO) o).getId());
    }


    @Override
    public int hashCode() {
        return 31;
    }

}
