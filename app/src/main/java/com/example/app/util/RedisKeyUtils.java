package com.example.app.util;

public class RedisKeyUtils {
    public static final  String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";
    public static final  String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";

    public static String getLikedKey(String postId, String userId) {
        StringBuilder builder = new StringBuilder();
        builder.append(postId);
        builder.append("::");
        builder.append(userId);
        return builder.toString();
    }
}
