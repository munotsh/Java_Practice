package com.example.Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumSumAfterKthCeilingOperation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 7};
        int k = 4;
        System.out.println(minSum(arr, k));
    }

    private static int minSum(int[] arr, int k) {
        PriorityQueue<Double> prio = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            prio.add((double) i);
        }

        while (k > 0) {
            System.out.println(prio);
            prio.add(Math.ceil(prio.poll() / 2));
            k--;
        }
        System.out.println(prio);
        int result = prio.stream().mapToInt(Double::byteValue).sum();
        System.out.println(result);
        return 0;
    }


}
