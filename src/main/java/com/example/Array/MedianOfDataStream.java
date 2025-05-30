package com.example.Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream {
    public static void main(String args[]) {
        MedianOfDataStream medianOfDataStream = new MedianOfDataStream();
        int[] num1 = {5, 2, 10, 3};
        medianOfDataStream.findMedian(num1);
     // output: Added: 5, Median: 5.0
              //Added: 2, Median: 3.5
              //Added: 10, Median: 5.0
              //Added: 3, Median: 4.0

    }

    private void findMedian(int[] num) {
        // Min-heap for the larger half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        // Max-heap for the smaller half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : num) {
            // Add number to the data stream
            if (minHeap.isEmpty() || n <= minHeap.peek()) {
                minHeap.offer(n);
            } else {
                maxHeap.offer(n);
            }
            // Balance the heaps
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            // Find the median
            if (maxHeap.size() == minHeap.size()) {
                System.out.println((minHeap.peek() + maxHeap.peek()) / 2.0);
            } else {
                System.out.println(minHeap.peek());
            }
        }
    }
}
