package com.jihaddmz.oneappurlbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class ControllerPing {


    public ControllerPing() {

    }

    @RequestMapping(method = RequestMethod.HEAD, value = "")
    public ResponseEntity<Void> ping() {
        return ResponseEntity.ok().build();
    }
}
