package com.management.task.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class BaseResponse<T> {

    private int status;
    private boolean success;
    private String message;

    @JsonIgnoreProperties
    private T data;

    public static <T> BaseResponse<T> ok(String message, T data){
        // buat baseResponse untuk success pertama kali ketika mau membuat api register
        return BaseResponse.<T>builder()
                .success(true)
                .status(200)
                .message(StringUtils.isNotEmpty(message)? message : "")
                .data(data)
                .build();
    }

    // untuk AccesDeniedConfig
    public static <T> BaseResponse<T> forbiddenAccess(String message) {
        return BaseResponse.<T>builder()
                .status(403)
                .success(false)
                .message(message)
                .data(null)
                .build();
    }
    // AuhenticationEntryPoint
    public static <T> BaseResponse<T> unauthorizedAccess(String message) {
        return BaseResponse.<T>builder()
                .status(401)
                .success(false)
                .message(message)
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> error(String message, T data){
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> badRequest(String message){
        return BaseResponse.<T>builder()
                .status(400)
                .success(false)
                .message(message)
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> create(int status, boolean success, String message, T data){
        return BaseResponse.<T>builder()
                .status(status)
                .success(success)
                .message(StringUtils.isNotBlank(message) ? message : " ")
                .data(data)
                .build();
    }

}
