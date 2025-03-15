package com.example.user_apitt.service;

import com.example.user_apitt.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void updateUser(User user, Long id);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User getUser(Long id);
}
