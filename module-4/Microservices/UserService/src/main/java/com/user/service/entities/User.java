package com.user.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Entity
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
    @Column(length = 100)
    private String about;

    @Transient
    List<Rating> ratings=new ArrayList<>();
    public User() {
        super();
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "about='" + about + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public User(List<Rating> ratings, String about, String email, String name, String userId) {
        this.ratings = ratings;
        this.about = about;
        this.email = email;
        this.name = name;
        this.userId = userId;
    }

    public User(String about, String email, String name, String userId) {
        this.about = about;
        this.email = email;
        this.name = name;
        this.userId = userId;
    }


    public User(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
