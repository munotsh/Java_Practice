package com.example.systemDesign.rateLimiter.slidingWindowLog;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
public class SlidingWindowLogRateLimiter {
    Queue<Long> slidingWindow;
    int timeWindowInSeconds;
    int bucketCapacity;
    public SlidingWindowLogRateLimiter(int timeWindowInSeconds, int bucketCapacity) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.bucketCapacity = bucketCapacity;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if (slidingWindow.size() < bucketCapacity) {
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }
    private void checkAndUpdateQueue(long currentTime) {
        if (slidingWindow.isEmpty()) return;
        long calculatedTime = (currentTime - slidingWindow.peek()) / 1000;
        while (calculatedTime >= timeWindowInSeconds) {
            slidingWindow.poll();
            if (slidingWindow.isEmpty()) break;
            calculatedTime = (currentTime - slidingWindow.peek()) / 1000;
        }
    }
}