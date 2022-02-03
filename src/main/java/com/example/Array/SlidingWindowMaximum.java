package com.example.Array;

import java.util.*;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        Output: [3,3,5,5,6,7]
//        int[] arr = {1};
//        int k = 1;
//        Output: [1]
        int[] res = slidingWindowMaximum.maxSlidingWindow(arr, k);
        Arrays.stream(res).forEach(System.out::print);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                p.add(nums[i]);
            } else {
                p.add(nums[i]);
                res[i-k+1] = p.peek();
            }
        }
        return res;
    }
}
