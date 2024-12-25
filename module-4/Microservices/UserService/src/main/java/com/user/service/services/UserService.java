package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User getUser(String userId);
    List<User> getAllUsers();
}
