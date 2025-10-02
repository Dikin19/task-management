package com.management.task.service.managementuser.impl;


import com.management.task.mapper.managementuser.Usermapper;
import com.management.task.model.app.SimpleMap;
import com.management.task.model.request.UserRequestRecord;
import com.management.task.repository.managementuser.UserRepository;
import com.management.task.service.managementuser.UserAuthService;
import com.management.task.service.managementuser.ValidatorService;
import com.management.task.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    //through constructor parameter 4"
    //→ artinya di constructor UserAuthServiceImpl, dependency ke-5 (index mulai dari 0) gagal dibuat.
    //Misalnya kalau constructornya kayak gini:
    // public UserAuthServiceImpl(A a, B b, C c, D d, JwtUtil jwtUtil) { ... }
    //maka JwtUtil yang gagal dibuat.
    private final UserRepository userRepository ;
    private final Usermapper usermapper;
    private final PasswordEncoder passwordEncoder;
    private final ValidatorService validatorService;
    private final JwtUtil jwtUtil;

    @Override
    public void register(UserRequestRecord request){

        validasiMandatory(request);

        var user = usermapper.requestToEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);
    }

    public SimpleMap login(UserRequestRecord request){

        validatorService.validator(request);

        var user = userRepository.findByUsername(request.username()
                .toLowerCase())
                // jika tidak ditemukan masuk error badrequest.
                .orElseThrow(() -> new RuntimeException("Username atau password salah"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())){
            // jika password tidak matches jalankan error.
            throw new RuntimeException("username atau password salah");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        user.setToken(token);

        user.setExpiredTokenAt(LocalDateTime.now().plusHours(1));

        userRepository.save(user);

        SimpleMap result = new SimpleMap();
        result.put("token", token);
        return result;




    }

    private void validasiMandatory(UserRequestRecord request){

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

    }




}
