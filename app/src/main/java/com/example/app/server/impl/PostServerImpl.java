package com.example.app.server.impl;

import com.example.app.mapper.PostMapper;
import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.model.User;
import com.example.app.server.PostServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Service
public class PostServerImpl implements PostServer {
    private Logger logger = Logger.getLogger(PostServerImpl.class.getName());
    private Timestamp timestamp;

    public PostServerImpl() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    @Autowired
    PostMapper postMapper;

    @Override
    public Resp addPost(Post post) {
        Resp resp = new Resp();
        post.setCreate_time(timestamp);
        post.setAuthor_id(Long.valueOf((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        this.postMapper.insert(post);
        return resp;
    }

    @Override
    public Resp getPosts() {
        Resp resp = new Resp();
//        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails().getId();
//        logger.info((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        resp.setData(this.postMapper.getPosts());
        return resp;
    }
}
