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

}
