package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(){
        return "user/login";
    }
    @GetMapping("/logout")
    public String sdfk(){
        return "redirect:login";
    }
    @PostMapping("/logout")
    public String shfk(){
        return "redirect:login";
    }
}