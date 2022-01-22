package com.example.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        BucketSort b = new BucketSort();
        int[] inputArray = {5, 8, 4, 6, 9, 3, 1, 2, 7};
        b.bucketSort(inputArray,inputArray.length);
        for (int i : inputArray)
            System.out.print(i + "  ");
    }
    public void bucketSort(int[] arr, int n) {
        if (n <= 0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bucket = new ArrayList[n];
        // Create empty buckets
        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<Integer>();
        // Add elements into the buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }
        // Sort the elements of each bucket
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }
        // Get the sorted array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }
}