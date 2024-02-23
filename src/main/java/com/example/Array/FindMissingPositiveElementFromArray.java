package com.example.Array;

import java.util.Arrays;

public class FindMissingPositiveElementFromArray {
    public static void main(String[] args) {
//        int[] arr = {1,3,6,4,1,2}; // o/p : 5
//        int[] arr = {-1,-3}; // o/p : 1
        int[] arr = {1,2,3}; // o/p : 4
        System.out.println(findElement(arr));
    }

    private static int findElement(int[] arr) {
        Arrays.sort(arr);
        int i=arr.length-1;
        boolean foundPositive = false;
        int result = 0;
        while(i>0){
            if(arr[i] > 0){
                foundPositive =true;
                if((arr[i] - arr[i-1]) > 1){
                    result = arr[i-1]+1;
                }
            }
            i--;
        }
        if(!foundPositive){
            result = 1;
        }
        else if(result == 0 && i == 0){
            result = arr[arr.length-1]+1;
        }
        return result;
    }

}
