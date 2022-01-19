package com.example.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = {1,4,2,6,7,5};
		
		for(int i=1;i<arr.length;i++) {
		int key = arr[i];
		int j=i-1;
		
		while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
		arr[j + 1] = key;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}

}
