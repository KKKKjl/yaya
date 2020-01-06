package com.example.app.model;


public class Heart {
    private Long id;
    private Long post_id;
    private Long user_id;
    private Long is_like;


    public Heart(Long post_id, Long user_id, Long is_like) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.is_like = is_like;
    }

    public Long getId() {
        return id;
    }

    public void setIs_like(Long is_like) {
        this.is_like = is_like;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getIs_like() {
        return is_like;
    }

}
