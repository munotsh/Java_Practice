package com.example.Array;

import java.util.Arrays;

public class EvenNumbersToLeftAndOddNumbersToRightOfArrayCountSwap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {1,2,3,4,5,8,8,8,8,10};
        System.out.println(moveElement(arr));

    }

    private static int moveElement(int[] arr) {
        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] % 2 == 0) {
                start++;
            } else if (arr[end] % 2 != 0) {
                end--;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                count++;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
        return count;
    }
}
