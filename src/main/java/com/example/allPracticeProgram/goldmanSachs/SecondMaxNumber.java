package com.example.allPracticeProgram.goldmanSachs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SecondMaxNumber {

    public static void main(String[] args) {
//		int[] arr = {3,2,4,6,10,1};
        int[] arr = {9, 2, 8, 3, 5, 4};
//		int[] arr = {9,9,9,9,9};

        // using manual code
        int secondMax = findSecondMaxNumber(arr);
        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("no second max value");
        } else {
            System.out.println("second max value" + secondMax);
        }

        // Using Priority queue
        int k = 2;
        PriorityQueue<Integer> prio = findSecondMaxNumberUsingPriorityQueue(arr);
        for (int i = 1; i < k; i++) {
            prio.remove();
        }
        System.out.println(prio.remove());
    }

    private static int findSecondMaxNumber(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i != max) {
                secondMax = i;
            }
        }
        return secondMax;
    }

    private static PriorityQueue<Integer> findSecondMaxNumberUsingPriorityQueue(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        return priorityQueue;
    }
}
