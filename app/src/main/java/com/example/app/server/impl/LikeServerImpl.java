package com.example.app.server.impl;

import com.example.app.model.Resp;
import com.example.app.model.UserLike;
import com.example.app.server.LikeServer;
import com.example.app.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Service
public class LikeServerImpl implements LikeServer {
    private Logger logger = Logger.getLogger(LikeServerImpl.class.getName());
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Resp setLikeStatus(String postId) {
        String key = RedisKeyUtils.getLikedKey(postId, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        logger.info(key);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, 1);
        return null;
    }

    @Override
    public Resp setUnlikeStatus(String postId) {
        String key = RedisKeyUtils.getLikedKey(postId, (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
        return null;
    }

    @Override
    public List<UserLike> getLikedDataFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED, ScanOptions.NONE);
        List<UserLike> list = new ArrayList<>();
        while (cursor.hasNext()){
            Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();

            String[] split = key.split("::");
            String likedUserId = split[1];
            String likedPostId = split[0];
            // Integer value = (Integer) entry.getValue();
            UserLike userLike = new UserLike(Long.valueOf(likedPostId), Long.valueOf(likedUserId), true);
            list.add(userLike);

            redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
        }

        return list;
    }
}
