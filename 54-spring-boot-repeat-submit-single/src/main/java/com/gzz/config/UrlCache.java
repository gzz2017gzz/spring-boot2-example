package com.gzz.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Configuration
/**
 * @功能描述 内存缓存
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
public class UrlCache {
    @Bean
    public Cache<String, Integer> getCache() {
        return CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();// 缓存有效期为2秒
    }
}