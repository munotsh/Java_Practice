package com.example.systemDesign.rateLimiter.slidingWindowCounter;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
public class SlidingWindowCounterRateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final ConcurrentHashMap<String, Deque<Long>> timestamps = new ConcurrentHashMap<>();
    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }
    public boolean isAllowed(String clientId) {
        // Get the timestamp deque for the client, creating a new one if it doesn't exist
        Deque<Long> clientTimestamps = timestamps.computeIfAbsent(clientId, k -> new ConcurrentLinkedDeque<>());
        // Get the current timestamp in milliseconds
        long currentTimeMillis = System.currentTimeMillis();
        // Remove timestamps older than the sliding window
        while (!clientTimestamps.isEmpty() && currentTimeMillis - clientTimestamps.peekFirst() > windowSizeInMillis) {
            clientTimestamps.pollFirst();
        }
        // Check if the number of requests in the sliding window exceeds the maximum allowed
        if (clientTimestamps.size() < maxRequests) {
            clientTimestamps.addLast(currentTimeMillis);
            return true; // Request is allowed
        }
        return false; // Request is not allowed
    }
}