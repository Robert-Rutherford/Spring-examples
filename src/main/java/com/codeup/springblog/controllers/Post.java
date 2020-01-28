package com.codeup.springblog.controllers;

public class Post {
    private String title;
    private String body;
    private long id;

    public Post(long id,String title,String body){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
