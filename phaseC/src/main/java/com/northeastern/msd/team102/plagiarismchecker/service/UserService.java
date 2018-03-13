package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByCredentials(User user) {
        return userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User findUserByUserId(long userId) {
        return userRepository.findUserByUserId(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
