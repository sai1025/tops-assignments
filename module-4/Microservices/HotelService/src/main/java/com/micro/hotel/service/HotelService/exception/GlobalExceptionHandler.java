package com.micro.hotel.service.HotelService.exception;

import com.micro.hotel.service.HotelService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException exception)
    {
        String message = exception.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,"Not Found",false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
