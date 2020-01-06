package com.example.app.server;

import com.example.app.model.Resp;
import com.example.app.model.Heart;

import java.util.List;

public interface LikeServer {
    Resp setLikeStatus(String postId);
    Resp setUnlikeStatus(String postId);
    List<Heart> getLikedDataFromRedis();
}
