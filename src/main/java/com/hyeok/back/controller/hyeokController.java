package com.hyeok.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hyeokController {

    @GetMapping("/index")
    public String index() {
        return "/index.html";
    }

    @GetMapping("/member/login")
    public String login() {
        return "/member/login.html";
    }
    
    @GetMapping("/member/signup")
    public String signup() { return "/member/signup.html";}
}
