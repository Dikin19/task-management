package com.management.task.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.task.model.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

// menangani kasus ketika user belum login (unauthenticated) tapi mencoba mengakses endpoint yang butuh login.
// HTTP 401 Unauthorized
@Component
public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        BaseResponse<?> errorResponse = BaseResponse.unauthorizedAccess("Unauthorized access, please login first");

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}
