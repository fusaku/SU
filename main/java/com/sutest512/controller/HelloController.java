package com.sutest512.controller;

import com.sutest512.entity.User;
import com.sutest512.service.UserService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")

public class HelloController {

    @GetMapping("/isSpringStarted")
    public String hello() {
        return "Started";
    }
    @Autowired
    private UserService userService;

    @GetMapping("/user-list")
    public List<User> getAll() {
        return userService.findOne();

    }
}
