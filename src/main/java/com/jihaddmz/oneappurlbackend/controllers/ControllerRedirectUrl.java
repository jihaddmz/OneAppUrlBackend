package com.jihaddmz.oneappurlbackend.controllers;

import com.jihaddmz.oneappurlbackend.components.CustomException;
import com.jihaddmz.oneappurlbackend.entities.EntityUrl;
import com.jihaddmz.oneappurlbackend.services.ServiceUrl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/u")
@RestController
public class ControllerRedirectUrl {

    private final ServiceUrl serviceUrl;

    public ControllerRedirectUrl(ServiceUrl serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    @GetMapping("/{slug}")
    public void redirect(@PathVariable("slug") String slug, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent == null) {
            throw new CustomException("User-Agent header is null", 400);
        }

        EntityUrl entityUrl = serviceUrl.getUrlBySlug(slug);
        if (userAgent.toLowerCase().contains("android")) {
            response.sendRedirect(entityUrl.getAndroidUrl());
        } else if (userAgent.toLowerCase().contains("iphone") || userAgent.toLowerCase().contains("ipad")) {
            response.sendRedirect(entityUrl.getIosUrl());
        }
    }
}
