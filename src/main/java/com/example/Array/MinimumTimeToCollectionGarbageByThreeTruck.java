package com.example.Array;

import java.util.HashMap;
import java.util.Map;

public class MinimumTimeToCollectionGarbageByThreeTruck {
    public static void main(String[] args) {
//        String[] t = {"MPM","","G"};
//        int[] d = {3,2,4}; // 19
//        String[] t = {"PGP","M"};
//        int[] d = {2,5}; // 15
//        String[] t = {"", "PP", "PP", "GM", ""};
//        int[] d = {2, 1, 1, 1, 2}; // 12
        String[] t = {"G","P","GP","GG"};
        int[] d = {2, 4,3,1}; // 24;
        System.out.println(garbageCollection(t, d));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < garbage.length; i++) {
            if (garbage[i].contains("M")) {
                map.put('M', i);
            }
            if (garbage[i].contains("P")) {
                map.put('P', i);
            }
            if (garbage[i].contains("G")) {
                map.put('G', i);
            }
        }
        int maxSum = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int sum = 0;
            int garCount = 0;
            for (int i = 0; i <= e.getValue(); i++) {
                sum = sum + travel[i];
                garCount = garCount + (garbage[i].length() - garbage[i].replace(e.getKey() + "", "").length());
            }
            maxSum = Math.max(((sum * 2) + garCount), maxSum);
        }
        return maxSum;
    }
}
