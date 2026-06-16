package com.career.user_service.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String status;
    private T data;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }
}