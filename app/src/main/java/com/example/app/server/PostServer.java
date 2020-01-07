package com.example.app.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.app.model.Post;
import com.example.app.model.Resp;

public interface PostServer {
    Resp addPost(Post post);
    Resp getPosts(Integer page, Integer limit);
    Resp delPosts(Post post);
    Resp getAllPosts(String id);
    Resp search(String post);
}
