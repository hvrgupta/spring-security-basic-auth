package com.example.L13_Spring_Security_Intro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping("/blogs")
    public String getBlogs() {
        return "Blogs API response from " + Thread.currentThread().getName();
    }
}
