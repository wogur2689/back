package com.hyeok.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hyeokController {

    @GetMapping("/index")
    public String index() {
        return "/index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "/login.html";
    }
}
