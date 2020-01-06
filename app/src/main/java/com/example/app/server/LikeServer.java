package com.example.app.server;

import com.example.app.model.Resp;
import com.example.app.model.UserLike;

import java.util.List;

public interface LikeServer {
    Resp setLikeStatus(String postId);
    Resp setUnlikeStatus(String postId);
    List<UserLike> getLikedDataFromRedis();
}
