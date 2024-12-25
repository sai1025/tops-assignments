package com.user.service.entities;

public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private double rating;
    private String remark;
    private Hotel hotel;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Rating() {

    }

    public Rating(String hotelId, double rating, String ratingId, String remark, String userId, Hotel hotel) {
        this.hotelId = hotelId;
        this.rating = rating;
        this.ratingId = ratingId;
        this.remark = remark;
        this.userId = userId;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
