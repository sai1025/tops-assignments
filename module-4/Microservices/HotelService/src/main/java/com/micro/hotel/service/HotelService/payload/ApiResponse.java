package com.micro.hotel.service.HotelService.payload;

public class ApiResponse {
    String message;
    boolean success;
    String status;

    public ApiResponse() {
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", status='" + status + '\'' +
                '}';
    }

    public ApiResponse(String message, String status, boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
    }
}
