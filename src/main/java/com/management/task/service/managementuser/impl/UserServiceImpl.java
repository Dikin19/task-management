package com.management.task.service.managementuser.impl;


import com.management.task.entity.managementuser.User;
import com.management.task.model.request.UserRequestRecord;
import com.management.task.repository.managementuser.UserRepository;
import com.management.task.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(UserRequestRecord request){

        if (request.username() == null || request.username().isEmpty()){
            throw new RuntimeException("username tidak boleh kosong");
        }

        if (request.password()== null || request.password().isEmpty()){
            throw new RuntimeException("password tidak boleh kosong");
        }

        if (request.role() == null){
            throw new RuntimeException("role tidak boleh kosong");
        }

        if (request.userStatus() == null){
            throw new RuntimeException("userStatus tidak boleh kosong");
        }

        if (userRepository.existsByUsername(request.username().toLowerCase())){
            throw new RuntimeException("Username [" + request.username() + "] sudah digunakan");
        }

        User user = User.builder()
                .username(request.username().toLowerCase())
                .password(request.password().toLowerCase())
                .role(request.role())
                .userStatus(request.userStatus())
                .createdDate(LocalDateTime.now())
                .createdBy("SYESTEM")
                .modifiedDate(LocalDateTime.now())
                .updatedBy("")
                .build();

        userRepository.save(user);



    }



}
