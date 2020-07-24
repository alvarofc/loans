package com.ironhack.edgeservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private Integer id;
    private String title;
    private String body;
    private Integer author;

    public Comment() {
    }

    public Comment(String title, String body, Integer author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
