package com.example.Array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
// OP : [1, 6], [8, 10], [15, 18] TC : O(nlogn) and SC : O(n)
//        int[][] intervals = {{1, 4}, {2, 3}, {8, 10}, {15, 18}};
//OP : [1, 4], [8, 10], [15, 18]

        int[][] result = obj.merge(intervals);
        Arrays.stream(result).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
