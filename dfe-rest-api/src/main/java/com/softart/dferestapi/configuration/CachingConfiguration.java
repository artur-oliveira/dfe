package com.softart.dferestapi.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;

import java.util.Collections;

@Configuration
@EnableCaching
public class CachingConfiguration {

    public static final String USER_CACHE = "usercache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(Collections.singleton(USER_CACHE).toArray(new String[]{}));
    }


    @Bean
    public UserCache userCache() {
        return new SpringCacheBasedUserCache(cacheManager().getCache(CachingConfiguration.USER_CACHE));
    }

}
