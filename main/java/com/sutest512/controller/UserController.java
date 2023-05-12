package com.sutest512.controller;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sutest512.entity.User;
import com.sutest512.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/Started")
    public String list() {
        return "Started";
    }

    @GetMapping("/user-list")
    public String detail( Model model) {
        List<User> userList = userService.findOne();
        model.addAttribute("userList", userList);
        return "testFront";
    }
}
