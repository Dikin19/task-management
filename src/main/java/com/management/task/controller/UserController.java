package com.management.task.controller;

import com.management.task.model.request.UserRequestRecord;
import com.management.task.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequestRecord request){
        userService.register(request);
        return ResponseEntity.ok("Data berhasil ditambah");
    }

}
