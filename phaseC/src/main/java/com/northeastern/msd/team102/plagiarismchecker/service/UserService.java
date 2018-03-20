package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for User entity.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * findUserByCredentials method returns user for a given username and password
     * @param user User
     * @return User
     */
    public User findUserByCredentials(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * findUserByUsername method returns a user for a given username
     * @param username Name of the user
     * @return User
     */
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * findUserByUserId method returns a user for a given user id.
     * @param userId
     * @return User
     */
    public User findUserByUserId(long userId) {
        return userRepository.findById(userId);
    }

    /**
     * createUser method saves a user in the database
     * @param user
     * @return User
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * findByUserType method returns a user by user type.
     * @param userType
     * @return User
     */
    public User findByUserType(String userType) {
        return userRepository.findByUserType(userType);
    }
}
