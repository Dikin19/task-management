package com.management.task.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationConfig jwtAuthenticationConfig;
    private final AuthenticationEntryPointConfig authenticationEntryPointConfig;
    private final AccessDeniedConfig accessDeniedConfig;

    //Register
    // ketika memasang spring security untuk password. otomatis semua api membutuhkan authentication.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // kita buat security custom agar api bisa digunakan tanpa login
    // jika tidak dibuat SecurityFilterChain api tidak akan ada yang berjalan.
    // Login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/usersAuth/login", "/usersAuth/register", "/users/register").permitAll()
                        // setelah ini kia butuh Aktifkan JPA Auditing dengan AuditorAware untuk created-By di file config
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(authenticationEntryPointConfig)
                        .accessDeniedHandler(accessDeniedConfig)
                )
                .addFilterBefore(jwtAuthenticationConfig, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    } // setelah ini kia butuh Aktifkan JPA Auditing dengan AuditorAware untuk created-By di file config

    // dibuat untuk logout
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }





}
