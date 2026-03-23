package com.avantika.blogapi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Blog API is running ";
    }
}
