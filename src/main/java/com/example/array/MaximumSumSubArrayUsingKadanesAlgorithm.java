package com.example.array;

public class MaximumSumSubArrayUsingKadanesAlgorithm {
    public static void main(String[] args) {
//		int[] arr = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 2, 1 };
//		int[] arr = { -4, 2, -5, 1, 2, 3, 6, -5, 1 };
        int[] arr = { -2,1,-3,4,-1,2,1,-5,4 }; // OP:6, 3 to 6

        int maxSoFar = arr[0];
        int maxEnd = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEnd = maxEnd + arr[i];
            if (maxSoFar < maxEnd) {
                maxSoFar = maxEnd;
                start = s;
                end = i;
            }
            if (maxEnd < 0) {
                maxEnd = 0;
                s = i + 1;
            }
        }
        System.out.println(maxSoFar);
        System.out.println(start + " to " + end);
    }
}
