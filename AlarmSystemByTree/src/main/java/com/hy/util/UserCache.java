package com.hy.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

// 存储当前登录系统的用户名
public class UserCache {
    private static final int EXPIRE_TIME_MINUTES = 30;
    private static Cache<String, String> cache;

    static {
        cache = Caffeine.newBuilder()
                .expireAfterWrite(EXPIRE_TIME_MINUTES, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
    }

    public static void put(String key, String value) {
        cache.put(key, value);
    }

    public static String get(String key) {
        return cache.getIfPresent(key);
    }

    public static void remove(String key) {
        cache.invalidate(key);
    }
}
