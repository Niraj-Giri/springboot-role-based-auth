package com.niraj.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Welcome {
    @GetMapping("/auth/user")
    public  String welcome()
    {
        return "Welcome to home page";
    }
}
