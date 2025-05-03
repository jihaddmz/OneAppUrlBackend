package com.jihaddmz.oneappurlbackend;

import lombok.Getter;

@Getter
public class DtoUrl {

    private String username;
    private String iosUrl;
    private String androidUrl;

    public DtoUrl(String username, String iosUrl, String androidUrl) {
        this.username = username;
        this.iosUrl = iosUrl;
        this.androidUrl = androidUrl;
    }
}
