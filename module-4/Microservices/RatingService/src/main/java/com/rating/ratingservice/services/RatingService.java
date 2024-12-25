package com.rating.ratingservice.services;

import com.rating.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating create(Rating rating);
    public List<Rating> findRatingsByUserId(String userId);
    public List<Rating> findRatingsByHotelId(String hotelId);
    public List<Rating> findAllRatings();
}
