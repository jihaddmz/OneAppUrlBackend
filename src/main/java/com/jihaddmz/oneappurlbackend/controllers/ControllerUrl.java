package com.jihaddmz.oneappurlbackend.controllers;

import com.jihaddmz.oneappurlbackend.DtoUrl;
import com.jihaddmz.oneappurlbackend.components.CustomException;
import com.jihaddmz.oneappurlbackend.entities.EntityUrl;
import com.jihaddmz.oneappurlbackend.services.ServiceUrl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/url")
public class ControllerUrl {

    private final ServiceUrl serviceUrl;

    public ControllerUrl(ServiceUrl serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

//    @GetMapping("")
//    public List<EntityUrl> getAll() {
//        return serviceUrl.getAll();
//    }

    @GetMapping("")
    public List<EntityUrl> getAllByUsername(@RequestParam String username) {
        return serviceUrl.getAllByUsername(username);
    }

    @PostMapping("/save")
    public EntityUrl save(@RequestBody DtoUrl url) {
        return serviceUrl.save(url.getUsername(), url.getIosUrl(), url.getAndroidUrl());
    }
}
