package com.example.Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindBiggestTwoNumbers {
    public static void main(String[] args) {
        int[] arr = {9, 2, 8, 3, 5, 4};
        int k = 3;
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            p.add(i);
        }

        while (k > 0) {
            System.out.println(p.peek());
            p.remove(p.peek());
            k--;
        }
    }
}
