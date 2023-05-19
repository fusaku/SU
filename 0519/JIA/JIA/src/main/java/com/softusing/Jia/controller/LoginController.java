package com.softusing.Jia.controller;


import com.softusing.Jia.form.User1Form;
import com.softusing.Jia.model.User1;
import com.softusing.Jia.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private User1Service user1Service;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user1Form",new User1Form());
        return "register";
    }

    @GetMapping("/login")
    public String longinPage() {
        return "login";
    }
    @GetMapping("/result")
    public String result(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User1 user1 = new User1();
        user1.setUsername(username);
        user1.setPassword(password);
        boolean flag = user1Service.login(user1);
        if(flag==true){
            return "redirect:/user1s";
        }else {
            return "Middle";
        }
    }

    @PostMapping("/register")
    public String register(@Valid User1Form user1Form, BindingResult result) {
        if (!user1Form.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError","两次密码不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }
        User1 user11 = user1Form.convertToUser();

        boolean flag = user1Service.saveFlag(user11);
        if(flag==true){
            user1Service.save(user11);
            return "redirect:/login";
        }else {
            return "failed";
        }
    }

    @GetMapping("/user1s")
    public String getUser1ByArray(Model model) {
        List<User1> user1s = user1Service.queryUser1ByArray();
        model.addAttribute("user1s", user1s);
        return "user1s";
    }

}
