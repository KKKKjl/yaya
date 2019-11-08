package com.example.app.server.impl;

import com.example.app.mapper.CommentMapper;
import com.example.app.model.Comment;
import com.example.app.model.Resp;
import com.example.app.server.CommentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentServerImpl implements CommentServer {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Resp addComment(Comment comment) {
        Resp resp = new Resp();
        comment.setAuthor_id(Long.valueOf((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        this.commentMapper.insert(comment);
        return resp;
    }

    @Override
    public Resp getComments(String id) {
        Resp resp = new Resp();
        resp.setData(this.commentMapper.getComments(id));
        return resp;
    }
}
