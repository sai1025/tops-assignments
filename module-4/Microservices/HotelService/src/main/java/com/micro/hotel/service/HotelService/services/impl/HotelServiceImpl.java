package com.micro.hotel.service.HotelService.services.impl;

import com.micro.hotel.service.HotelService.entities.Hotel;
import com.micro.hotel.service.HotelService.exception.ResourceNotFoundException;
import com.micro.hotel.service.HotelService.repository.HotelRepository;
import com.micro.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String uid = UUID.randomUUID().toString();
        hotel.setId(uid);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));
    }
}
