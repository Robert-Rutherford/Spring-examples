package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model){
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "login";
    }
}
