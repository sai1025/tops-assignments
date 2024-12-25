package com.micro.hotel.service.HotelService.services;

import com.micro.hotel.service.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel create(Hotel hotel);
    public List<Hotel> getAllHotels();
    public Hotel getHotelById(String hotelId);
}
