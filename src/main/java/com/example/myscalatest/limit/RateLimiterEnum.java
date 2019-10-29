package com.example.myscalatest.limit;

import com.google.common.util.concurrent.RateLimiter;

public enum RateLimiterEnum {

    LIMITER_MATCH_USER_ID(RateLimiterFactory.rateLimiterForMatchUserId()),
    ;

    private final RateLimiter rateLimiter;

    RateLimiterEnum(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public RateLimiter getRateLimiter() {
        return rateLimiter;
    }

    static class RateLimiterFactory {
        // 雪盈数据匹配接口 每秒qps限制在200
        static RateLimiter rateLimiterForMatchUserId() {
            return RateLimiter.create(200);
        }
    }
}
