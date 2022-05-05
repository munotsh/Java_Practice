package com.example.Array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeTwoIntervalLists {
    public static void main(String[] args) {
        MergeTwoIntervalLists obj = new MergeTwoIntervalLists();
        int[][] interval1 = {{1,5}, {10,14}, {16,18}};
        int[][] interval2 = {{2, 6}, {8, 10}, {11, 20},{21,23}};
        int[][] result = obj.mergeList(interval1, interval2);
        Arrays.stream(result).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public int[][] mergeList(int[][] l1, int[][] l2) {
        Arrays.sort(l1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(l2, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (i < l1.length && j < l2.length) {
            int min = Math.min(l1[i][0], l2[i][0]);
            int max = Math.max(l1[i][1], l2[i][1]);
            int[] arr = {min, max};
            if (result.isEmpty()) {
                result.add(arr);
            } else if ((min - result.getLast()[1]) > 0) {

                result.add(arr);
            } else {
                result.getLast()[0] = Math.min(result.getLast()[0], min);
                result.getLast()[1] = Math.max(result.getLast()[1], max);
            }
            i++;
            j++;
        }
        if(i != l1.length){
            mergeSingle(l1, result, i);
        }
        if(j != l2.length){
            mergeSingle(l2, result, j);
        }
        return result.toArray(new int[result.size()][]);
    }

    private void mergeSingle(int[][] l1, LinkedList<int[]> result, int i) {
        while (i < l1.length) {
            if (result.isEmpty()) {
                result.add(l1[i]);
            } else if ((l1[i][0] - result.getLast()[1]) > 0) {
                result.add(l1[i]);
            } else {
                result.getLast()[0] = Math.min(result.getLast()[0], l1[i][0]);
                result.getLast()[1] = Math.max(result.getLast()[1], l1[i][1]);
            }
            i++;
        }
    }
}
