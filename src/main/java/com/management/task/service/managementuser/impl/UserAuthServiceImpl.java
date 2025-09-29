package com.management.task.service.managementuser.impl;


import com.management.task.mapper.managementuser.Usermapper;
import com.management.task.model.request.UserRequestRecord;
import com.management.task.repository.managementuser.UserRepository;
import com.management.task.service.managementuser.UserAuthService;
import com.management.task.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository ;
    private final Usermapper usermapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRequestRecord request){

        validasiMandatory(request);

        var user = usermapper.requestToEntity(request);
        userRepository.save(user);
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
