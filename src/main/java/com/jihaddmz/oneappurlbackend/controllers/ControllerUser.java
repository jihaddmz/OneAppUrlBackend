package com.jihaddmz.oneappurlbackend.controllers;

import com.jihaddmz.oneappurlbackend.entities.EntityUser;
import com.jihaddmz.oneappurlbackend.services.ServiceUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class ControllerUser {

    private final ServiceUser serviceUser;

    public ControllerUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("")
    public List<EntityUser> getAll() {
        return serviceUser.getAllUsers();
    }

    @PostMapping("/save")
    public EntityUser saveUser(@RequestBody Map<String, String> body) {
        return serviceUser.saveUser(body.get("username"), body.get("password"));
    }
}
