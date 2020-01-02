package com.example.app.server;

import com.example.app.model.Resp;

public interface LikeServer {
    Resp setLikeStatus(String postId);
    Resp setUnlikeStatus(String postId);
}
