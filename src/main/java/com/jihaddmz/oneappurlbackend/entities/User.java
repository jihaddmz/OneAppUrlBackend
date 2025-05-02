package com.jihaddmz.oneappurlbackend.entities;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class User {

    @Id
    private String id;

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
