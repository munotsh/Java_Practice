package com.example.systemDesign.rateLimiter.slidingWindowLog;
import java.util.HashMap;
import java.util.Map;
public class UserBucketCreator {
    Map<Integer, SlidingWindowLogRateLimiter> bucket;
    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindowLogRateLimiter(1, 5));
    }
    void accessApplication(int id) {
        if (bucket.get(id).grantAccess()) {
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}