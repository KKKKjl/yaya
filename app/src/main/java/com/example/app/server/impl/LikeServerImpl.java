package com.example.app.server.impl;

import com.example.app.model.Resp;
import com.example.app.server.LikeServer;
import com.example.app.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class LikeServerImpl implements LikeServer {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Resp setLikeStatus(String postId) {
        String key = RedisKeyUtils.getLikedKey(postId, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, 1);
        return null;
    }

    @Override
    public Resp setUnlikeStatus(String postId) {
        String key = RedisKeyUtils.getLikedKey(postId, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
        return null;
    }
}
