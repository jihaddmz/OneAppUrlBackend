package com.jihaddmz.oneappurlbackend.controllers;

import com.jihaddmz.oneappurlbackend.DtoUrl;
import com.jihaddmz.oneappurlbackend.entities.EntityUrl;
import com.jihaddmz.oneappurlbackend.services.ServiceUrl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/filter")
    public List<EntityUrl> getAllByQuery(@RequestParam String query) {
        return serviceUrl.searchUrls(query);
    }

    @PostMapping("/save")
    public EntityUrl save(@RequestBody DtoUrl url) {
        return serviceUrl.save(url.username(), url.iosUrl(), url.androidUrl(), url.appName());
    }

    @DeleteMapping("/delete/{id}")
    public EntityUrl delete(@PathVariable("id") String id) {
        return serviceUrl.delete(id);
    }
}
