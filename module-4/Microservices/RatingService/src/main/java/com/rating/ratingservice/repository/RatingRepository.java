package com.rating.ratingservice.repository;

import com.rating.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    public List<Rating> findByUserId(String userId);
    public List<Rating> findByHotelId(String hotelId);

}
