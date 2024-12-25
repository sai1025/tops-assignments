package com.micro.hotel.service.HotelService.controllers;

import com.micro.hotel.service.HotelService.entities.Hotel;
import com.micro.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel)
    {
        return hotelService.create(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels()
    {
     return hotelService.getAllHotels();
    }
    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId){
        return hotelService.getHotelById(hotelId);
    }
}
