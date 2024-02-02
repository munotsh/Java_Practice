package com.example.companies.loblaw;

import java.util.ArrayList;
import java.util.List;

public class SumKNumberOfElementToTargetedSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int tar = 12;
        int len = 4;
        List<Integer> result = getSum(arr, tar, len);
    }

    private static List<Integer> getSum(int[] arr, int tar, int len) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(arr[i]);
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (l.size() < len) {
                        l.add(arr[j]);
                    } else {
                        int sum = l.stream().mapToInt(Integer::intValue).sum();
                        if (sum == tar)
                            System.out.println(l);
                        l = new ArrayList<>();
                        l.add(arr[i]);
                    }
                }

            }
            if (l.size() == len) {
                int sum = l.stream().mapToInt(Integer::intValue).sum();
                if (sum == tar)
                    System.out.println(l);
            }
        }
        return null;
    }
}
