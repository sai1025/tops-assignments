package com.user.service.entities;



public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;

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


}

