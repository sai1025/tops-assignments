package com.micro.hotel.service.HotelService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {
    @Override
    public String toString() {
        return "Hotel{" +
                "about='" + about + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel(String about, String id, String location, String name) {
        this.about = about;
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public Hotel() {
        super();
    }

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
