package com.example.companies.loblaw;

import java.util.Arrays;

public class CheckPairSumZeroReturnTrueOrFalse {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 9, 4, -5, -4};
//        int[] arr = {1, 2, 9, -5, -4};
//        int[] arr = {1, 2, -3, 9, 4, -5, -4};
        int[] arr = {2, -7,3,4, 5, -1,6,7};
        System.out.println(findPairSumZero(arr));
    }

    private static boolean findPairSumZero(int[] arr) {
        Arrays.sort(arr);
        int start =0;
        int end = arr.length-1;
        while(start<end){
            if(arr[start]+arr[end] == 0){
                return true;
            }
            else if(arr[start]+arr[end]>0){
                end--;
            }
            else{
                start++;
            }
        }
        return false;
    }
}
