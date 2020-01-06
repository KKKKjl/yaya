package com.example.app.model;


import java.sql.Timestamp;

/**
 * 用户实体类
 */
public class User {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String avatar_url;
    private Timestamp create_time;
    private Timestamp update_time;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setCreateTime(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUpdateTime(Timestamp update_time) {
        this.update_time = update_time;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreateTime() {
        return create_time;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getUpdateTime() {
        return update_time;
    }
}