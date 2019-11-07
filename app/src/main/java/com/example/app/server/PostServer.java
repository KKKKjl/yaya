package com.example.app.server;

import com.example.app.model.Post;
import com.example.app.model.Resp;

public interface PostServer {
    Resp addPost(Post post);
    Resp getPosts();
}
