package com.example.systemDesign.rateLimiter.fixedWindowCounter;
import java.util.HashMap;
import java.util.Map;
public class FixedWindowRateLimiter {
    private final int maxRequestPerWindow;
    private final long windowSizeInMillis;
    private final Map<String, Window> store = new HashMap<>();
    public FixedWindowRateLimiter(int maxRequestPerWindow, long windowSizeInMillis) {
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.windowSizeInMillis = windowSizeInMillis;
    }
    public synchronized boolean isAllowed(String clientId) {
        long currentTimeMillis = System.currentTimeMillis();
        Window window = store.get(clientId);
        // If the window doesn't exist or has expired, create a new window
        if (window == null || window.getStartTime() < currentTimeMillis - windowSizeInMillis) {
            window = new Window(currentTimeMillis, 0);
        }
        // Check if the number of requests in the window exceeds the maximum allowed
        if (window.getRequestCount() >= maxRequestPerWindow) {
            return false; // Request is not allowed
        }
        // Increment the request count and update the window in the store
        window.setRequestCount(window.getRequestCount() + 1);
        store.put(clientId, window);
        return true; // Request is allowed
    }
    private static class Window {
        private final long startTime;
        private int requestCount;
        public Window(long startTime, int requestCount) {
            this.startTime = startTime;
            this.requestCount = requestCount;
        }
        public long getStartTime() {
            return startTime;
        }
        public int getRequestCount() {
            return requestCount;
        }
        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }
    }
}

