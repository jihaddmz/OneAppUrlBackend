package com.jihaddmz.oneappurlbackend.controllers;

import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import com.jihaddmz.oneappurlbackend.services.ServiceUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ControllerUser {

    private final ServiceUser serviceUser;

    public ControllerUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("")
    public List<EntityUser> getAll() {
        return serviceUser.getAllUsers();
    }

    @PostMapping("/signup")
    public Map<String, Boolean> signUpUser(@RequestBody Map<String, String> body) {
        return serviceUser.signupUser(body.get("username"), body.get("fullName"), body.get("password"));
    }

    @PostMapping("/signin")
    public Map<String, String> signInUser(@RequestBody Map<String, String> body) {
        return serviceUser.signInUser(body.get("username"), body.get("password"));
    }
}
