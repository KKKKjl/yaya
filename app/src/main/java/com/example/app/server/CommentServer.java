package com.example.app.server;

import com.example.app.model.Comment;
import com.example.app.model.Resp;

public interface CommentServer {
    Resp addComment(Comment comment);
    Resp getComments(String id);
}
