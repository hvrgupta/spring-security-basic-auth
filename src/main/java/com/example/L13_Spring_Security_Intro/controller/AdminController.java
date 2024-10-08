package com.example.L13_Spring_Security_Intro.controller;

import com.example.L13_Spring_Security_Intro.entity.AppUser;
import com.example.L13_Spring_Security_Intro.service.AppUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @PostMapping("/createUser")
    ResponseEntity<Long> createUser(@RequestBody AppUser appUser) {
        Long id = appUserDetailsService.createUser(appUser);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/hello")
    public String helloAdmin(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("User info: " + ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()) );
        log.info("User info with Auth principal " + userDetails.getUsername());
        return "Hello Admin from " + Thread.currentThread().getName();
    }
}
