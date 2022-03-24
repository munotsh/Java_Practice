package com.example.Array;

//Sliding window technique TS:O(n)
public class MaximumSumSubArraySlidingWindow {
    public static void main(String[] args) {
//        int[] arr={1,9,-1,-2,7,3,-1,2};
//        int k=4;
//        Output : 13
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
//        Output: 9
        System.out.println(MaxSumSubarray(arr, k));
    }

    private static int MaxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                windowSum += arr[i];
                maxSum = windowSum;
            } else {
                windowSum += arr[i] - arr[i - k];
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        return maxSum;
    }
}
