package com.jihaddmz.oneappurlbackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "urls")
public class EntityUrl {

    @Id
    private String _id;

    private String username;
    private String slug;
    private String iosUrl;
    private String androidUrl;

    public EntityUrl() {
    }

    public EntityUrl(String username, String slug, String iosUrl, String androidUrl) {
        this.username = username;
        this.slug = slug;
        this.iosUrl = iosUrl;
        this.androidUrl = androidUrl;
    }
}
