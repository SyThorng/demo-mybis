package com.example.demomybatis;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUser();
    }

    public User getById(Integer userId) {

        return userRepository.getById(userId);
    }

    public User create(User user) {
        return userRepository.create(user);
    }

    public User deleteById(Integer userId) {
        return userRepository.deleteById(userId);
    }

    public User updateById(Integer userId,User user) {
        return userRepository.updateById(userId,user);
    }
}
