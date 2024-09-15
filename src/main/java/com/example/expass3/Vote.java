package com.example.expass3;

import java.time.Instant;

public class Vote {
    private String username;
    private Instant publishedAt;
    private Integer option;

    public Vote(String username, Integer option) {
        this.username = username;
        this.option = option;
        this.publishedAt = Instant.now();
    }

    public String getUsername() {
        return username;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public Integer getOption() {
        return option;
    }
}
