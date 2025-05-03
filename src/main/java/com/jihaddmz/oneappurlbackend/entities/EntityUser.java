package com.jihaddmz.oneappurlbackend.entities;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "users")
public class EntityUser {

    @Id
    private String username;

    private String fulName;
    private String password;

    public EntityUser() {
    }

    public EntityUser(String username, String fulName, String password) {
        this.username = username;
        this.fulName = fulName;
        this.password = password;
    }
}
