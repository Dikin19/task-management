package com.management.task.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    // ketika memasang spring security untuk password. otomatis semua api membutuhkan authentication.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // kita buat security custom agar api bisa digunakan tanpa login
    // jika tidak dibuat SecurityFilterChain api tidak akan ada yang berjalan.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/users/register", "/usersAuth/register").permitAll()
                        // setelah ini kia butuh Aktifkan JPA Auditing dengan AuditorAware untuk created-By di file config
                        .anyRequest().authenticated()
                );
        return http.build();

    } // setelah ini kia butuh Aktifkan JPA Auditing dengan AuditorAware untuk created-By di file config





}
