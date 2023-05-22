package com.softusing.Jia.web;


import com.softusing.Jia.form.User1Form;
import com.softusing.Jia.model.User1;
import com.softusing.Jia.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @PostMapping("/register")
    public String register(@Valid User1Form user1Form, BindingResult result) {
        if (!user1Form.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError","两次密码不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }
        User1 user11 = user1Form.convertToUser1();
        user1Service.save(user11);
        return "redirect:/login";
    }
@GetMapping("/exceotion")
    public String testException(){
        throw new RuntimeException();
    }
}
