package com.rating.ratingservice.entities;

import org.springframework.data.annotation.Id;

public class Rating {
    @Id
    String ratingId;
    String hotelId;
    String userId;
    int rating;

    @Override
    public String toString() {
        return "Rating{" +
                "hotelId='" + hotelId + '\'' +
                ", ratingId='" + ratingId + '\'' +
                ", userId='" + userId + '\'' +
                ", rating=" + rating +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Rating() {
    }

    public Rating(String hotelId, int rating, String ratingId, String remark, String userId) {
        this.hotelId = hotelId;
        this.rating = rating;
        this.ratingId = ratingId;
        this.remark = remark;
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

    String remark;
}
