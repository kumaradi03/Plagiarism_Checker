package com.northeastern.msd.team102.plagiarismchecker.controller;



import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        return userService.findUserByCredentials(user);
    }

    @GetMapping("/findUserByUsername")
    public User findUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("/findUserByUserId")
    public User findUserByUserId(@RequestParam long userId) {
        return userService.findUserByUserId(userId);
    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
