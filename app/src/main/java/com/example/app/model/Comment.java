package com.example.app.model;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private String content;
    private Long author_id;
    private Long post_id;
    private Timestamp create_time;
    private Timestamp update_time;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public Long getPost_id() {
        return post_id;
    }
}
