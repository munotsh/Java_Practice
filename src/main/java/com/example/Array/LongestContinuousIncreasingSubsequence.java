package com.example.Array;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence obj = new LongestContinuousIncreasingSubsequence();
        int[] arr = {1,3,5,4,7};
        // OP: 3
        System.out.println(obj.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int[] nums) {
        int longest = 1;
        int currentLongest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                currentLongest ++;
            } else {
                longest = Math.max(longest, currentLongest);
                currentLongest = 1;
            }
        }
        return Math.max(longest, currentLongest);
    }
}
