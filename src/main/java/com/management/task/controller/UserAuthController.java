package com.management.task.controller;


import com.management.task.model.request.UserRequestRecord;
import com.management.task.model.response.BaseResponse;
import com.management.task.service.managementuser.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usersAuth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;

    @PostMapping("/register")
    public BaseResponse<?> register(@RequestBody UserRequestRecord request){
        userAuthService.register(request);
        return BaseResponse.ok("Data berhasil disimpan", null);

    }

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody UserRequestRecord request){
        return BaseResponse.ok(null, userAuthService.login(request));
    }

//    @GetMapping("/logout")
//    public BaseResponse<?> logout(AuthenticationPrincipal )



}
