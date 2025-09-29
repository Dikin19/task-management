package com.management.task.mapper.managementuser;


import com.management.task.entity.managementuser.User;
import com.management.task.model.request.UserRequestRecord;
import org.springframework.stereotype.Component;

@Component
public class Usermapper {

    public User requestToEntity(UserRequestRecord request){

        return User.builder()
                .username(request.username().toLowerCase())
                .password(request.password())
                .role(request.role())
                .userStatus(request.userStatus())
                .build();

    }


}
