package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.constants.URI;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = URI.USERS_BASE_URI)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = URI.USERS_LOGIN_URI)
    public User Login(@RequestBody User user){
        return userService.findUserByCredentials(user);
    }
}
