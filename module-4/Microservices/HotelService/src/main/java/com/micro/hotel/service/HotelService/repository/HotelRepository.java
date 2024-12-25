package com.micro.hotel.service.HotelService.repository;

import com.micro.hotel.service.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
