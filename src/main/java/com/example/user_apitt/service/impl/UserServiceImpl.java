package com.example.user_apitt.service.impl;


import com.example.user_apitt.entity.User;
import com.example.user_apitt.repository.UserRepository;
import com.example.user_apitt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long id) {

        User user1 =  userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User with id " + id + " not found"));
        System.out.println(user1);
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());

        userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        for (User newList : userRepository.findAll()) {
            list.add(newList);
        }
        return list;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
