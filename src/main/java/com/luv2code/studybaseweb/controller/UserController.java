package com.luv2code.studybaseweb.controller;

import com.luv2code.studybaseweb.entity.User;
import com.luv2code.studybaseweb.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/user/{User_Id}")
    public User getUserById(@PathVariable String User_Id) {
        return userService.findById(User_Id);
    }


}
