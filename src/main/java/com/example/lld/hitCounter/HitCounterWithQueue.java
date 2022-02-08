package com.example.lld.hitCounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterWithQueue {
    Queue<Integer> queue;
    private final int FIVE_MINUTES = 300;

    public HitCounterWithQueue() {
        queue = new LinkedList<>();
    }

    // Time Complexity : O(1)
    public void hit(int timestamp)
    {
        queue.add(timestamp);
        int start = timestamp - FIVE_MINUTES + 1;
        while(queue.peek()<start) queue.remove();
    }

    // Time Complexity : O(n)
    public int getHits(int timestamp)
    {
        int start = timestamp - FIVE_MINUTES + 1;
        while(queue.peek()<start)
            queue.remove();
        return queue.size();
    }
}
