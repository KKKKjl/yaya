package com.example.app.controller;

import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.model.User;
import com.example.app.server.PostServer;
import com.example.app.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api")
public class UserController {
    @Autowired
    UserServer userServer;

    @Autowired
    PostServer postServer;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Resp insertUserInfo(User user) {
        return userServer.insertUserInfo(user);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Resp auth(User user) {
        return userServer.auth(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Resp getUserInfo(@RequestParam String nickname) {
        return userServer.getUserInfo(nickname);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Resp getUserList() {
        return userServer.getAllUsers();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Resp addPost(Post post) {
        return postServer.addPost(post);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public Resp getPosts() {
        return postServer.getPosts();
    }
}
