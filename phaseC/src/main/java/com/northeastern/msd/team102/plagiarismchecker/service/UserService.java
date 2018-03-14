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
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserByUserId(long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByUserType(String userType) {
        return userRepository.findByUserType(userType);
    }
}
