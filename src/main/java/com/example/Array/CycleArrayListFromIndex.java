package com.example.Array;

import java.util.*;

public class CycleArrayListFromIndex {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 4, 3, 5};
        System.out.println(findCycleInList(arr));
    }

    private static List findCycleInList(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                i = arr[i];
            }
            if(!list.isEmpty())
                result.add(list);
            list = new ArrayList<>();
        }
        System.out.println(result);
        return null;
    }
}
