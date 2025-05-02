package com.jihaddmz.oneappurlbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ControllerUser {

    @GetMapping("")
    public String getUser() {
        return "Hello World! from user endpoint";
    }
}
