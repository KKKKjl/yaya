package com.example.app.server.impl;

import com.example.app.mapper.PostMapper;
import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.server.PostServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServerImpl implements PostServer {
    @Autowired
    PostMapper postMapper;

    @Override
    public Resp addPost(Post post) {
        Resp resp = new Resp();
        this.postMapper.insert(post);
        return resp;
    }

    @Override
    public Resp getPosts() {
        Resp resp = new Resp();
        resp.setData(this.postMapper.getPosts());
        return resp;
    }
}
