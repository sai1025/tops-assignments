package com.micro.hotel.service.HotelService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @GetMapping
    public List<String> getCities()
    {
        return List.of("mumbai","delhi","chennai");
    }
}
