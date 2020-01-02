package com.example.app.controller;

import com.example.app.model.Comment;
import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.model.User;
import com.example.app.server.CommentServer;
import com.example.app.server.LikeServer;
import com.example.app.server.PostServer;
import com.example.app.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    LikeServer likeServer;

    @Autowired
    UserServer userServer;

    @Autowired
    PostServer postServer;

    @Autowired
    CommentServer commentServer;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Resp insertUserInfo(User user) {
        return userServer.insertUserInfo(user);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth() {
        return "s";
    }
//    public Resp auth(User user) {
//        return userServer.auth(user);
//    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Resp getUserInfo() {
        return userServer.getUserInfo();
    }

    @RequestMapping(value = "/user/{img}", method = RequestMethod.PATCH)
    public Resp updateUserInfo(@PathVariable String img) {
        return userServer.updateUserInfo(img);
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

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public  Resp addComment(Comment comment) {
        return commentServer.addComment(comment);
    }

    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public Resp getComments(@RequestParam String id) {
        return commentServer.getComments(id);
    }


    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public Resp setLikeStatus(@RequestParam String postId) {
        return likeServer.setLikeStatus(postId);
    }

    @RequestMapping(value = "/unlike", method = RequestMethod.DELETE)
    public Resp setUnlikeStatus(@RequestParam String postId) {
        return likeServer.setUnlikeStatus(postId);
    }
}
