package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for User entity.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Login method which receives the request for login.
     * @param user  User object
     * @return returns the user object whose login is requested.
     */
    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        return userService.findUserByCredentials(user);
    }

    /**
     * findUserByUsername method which receives the request for getting the user by username.
     * @param username
     * @return returns the user object for a given username.
     */
    @GetMapping("/findUserByUsername")
    public User findUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * findUserByUserId method which receives the request for getting the user by userID.
     * @param userId
     * @return returns the user object for a given username.
     */
    @GetMapping("/findUserByUserId")
    public User findUserByUserId(@RequestParam long userId) {
        return userService.findUserByUserId(userId);
    }

    /**
     * findProfessor method which receives the request for fetching the professor.
     * @return returns the user object who is a professor.
     */
    @GetMapping("/findProfessor")
    public User findProfessor() {
        return userService.findByUserType("Professor");
    }

    /**
     * registerUser method for registering a user.
     * @param user
     * @return returns the user object that is registered.
     */
    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
