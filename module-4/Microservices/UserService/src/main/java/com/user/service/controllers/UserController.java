package com.user.service.controllers;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.external.services.HotelService;
import com.user.service.external.services.RatingService;
import com.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

    @Autowired
    RatingService ratingService;


    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user)
    {
        System.out.println("adding user");
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        //Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/rating/user/" + user.getUserId(), Rating[].class);

        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        List<Rating> ratingList = ratings.stream().map(rating -> {

            //Hotel forObject = restTemplate.getForObject("http://HOTELSERVICE/hotel/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/user")
    public  ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
