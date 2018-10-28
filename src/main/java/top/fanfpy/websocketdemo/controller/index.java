package top.fanfpy.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.websocketdemo.entity.User;
import top.fanfpy.websocketdemo.service.impl.UserServiceImpl;

@RestController
public class index {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/login")
    public Boolean login(User user){
        return userService.login(user);
    }

    @PostMapping(value = "/login")
    public User newUser(User user){
        return userService.addUser(user);
    }
}
