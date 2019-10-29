package com.example.myscalatest.limit;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

public class RateLimiterExample2 {

    public static void main(String[] args) throws Exception {
        RateLimiter limiter = RateLimiter.create(1);

        for (int i = 1; i < 10; i = i + 2) {
            if (limiter.tryAcquire()) {
                System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i);
                TimeUnit.MILLISECONDS.sleep(500);
            }
            // System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }

}
