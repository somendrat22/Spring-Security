package com.spring.security.demo.Spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String homePage(){
        return "In HomePage";
    }

    @GetMapping("/login")
    public String login(){
        return "Login Page";
    }

    @GetMapping("/signup")
    public String signup(){
        userRepository.save(new UserInfo(1, "Somendra", "Somendra", "123456"));
        return"Signup page";
    }

}
