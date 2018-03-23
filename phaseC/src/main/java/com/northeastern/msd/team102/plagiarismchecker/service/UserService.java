package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.UserRepository;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service class for User entity.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static final Logger logger = Logger.getLogger(UserService.class.getName());

    /**
     * findUserByCredentials method returns user for a given username and password
     * @param user User
     * @return User
     */
    public User findUserByCredentials(User user) {
        logger.log(Level.INFO, "Returning user for username" + user.getUsername() + "and"
        + "password" + user.getPassword());
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * findUserByUsername method returns a user for a given username
     * @param username Name of the user
     * @return User
     */
    public User findUserByUsername(String username) {

        logger.log(Level.INFO, "Returning user for username" + username);
        return userRepository.findByUsername(username);
    }

    /**
     * findUserByUserId method returns a user for a given user id.
     * @param userId
     * @return User
     */
    public User findUserByUserId(long userId) {

        logger.log(Level.INFO, "Returning user for userID" + userId);
        return userRepository.findById(userId);
    }

    /**
     * createUser method saves a user in the database
     * @param user
     * @return User
     */
    public User createUser(User user) {

        logger.log(Level.INFO, "Creating user with username " + user.getUsername());
        return userRepository.save(user);
    }

    /**
     * findByUserType method returns a user by user type.
     * @param userType
     * @return User
     */
    public User findByUserType(String userType) {

        logger.log(Level.INFO, "Returning user with type " + userType);
        return userRepository.findByUserType(userType);
    }
}
