package com.user.service.external.services;

import com.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable String userId);
}
