package com.example.app.server;

import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.model.User;

import java.util.List;

public interface UserServer {
    Resp insertUserInfo(User user);
    Resp auth(User user);
    Resp getAllUsers();
    Resp getUserInfo(String nickname);
}