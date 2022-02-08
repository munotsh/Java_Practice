package com.example.Array;

import java.util.*;

public class RankTransformOfAnArray {
    public static void main(String[] args) {
        //int[] A = {10, 8, 15, 12, 6, 20, 1, 8};
        //output : [4, 3, 6, 5, 2, 7, 1, 3]
        //int[] A = {10, 8, 15, 12, 6, 20, 1};
        //output : [4, 3, 6, 5, 2, 7, 1]
        int[] A = {-4, -2, -3, -7};
        //[2, 4, 3, 1]
        transform(A);
        System.out.println(Arrays.toString(A));
    }

    public static void transform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        int rank = 1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(int i:entry.getValue()){
                arr[i] = rank;
            }
            rank++;
        }
    }


}
