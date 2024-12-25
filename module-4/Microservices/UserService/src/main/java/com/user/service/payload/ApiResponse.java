package com.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder

public class ApiResponse {
    public ApiResponse(HttpStatus httpStatus, String message, boolean success) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.success = success;
    }

    public ApiResponse() {
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean success;
    private HttpStatus httpStatus;

}
