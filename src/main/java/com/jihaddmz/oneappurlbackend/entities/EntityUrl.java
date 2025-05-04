package com.jihaddmz.oneappurlbackend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    private String appName;
    private String dateCreated;
    private int visits;

    public EntityUrl() {
    }

    public EntityUrl(String username, String slug, String iosUrl, String androidUrl, String appName) {
        this.username = username;
        this.slug = slug;
        this.iosUrl = iosUrl;
        this.androidUrl = androidUrl;
        this.appName = appName;

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        this.dateCreated = "Created on " + today.format(formatter);
        this.visits = 0;
    }
}
