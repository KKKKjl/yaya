package com.example.app.model;

import java.sql.Timestamp;

public class Post {
    private long id;
    private User user;
    private String content;
    private String img_url;
    private long author_id;
    private Timestamp create_time;
    private Timestamp update_time;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getImg_url() {
        return img_url;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }
}
