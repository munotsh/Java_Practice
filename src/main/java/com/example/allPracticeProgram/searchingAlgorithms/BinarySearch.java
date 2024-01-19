package com.example.allPracticeProgram.searchingAlgorithms;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] l = { 1, 4, 2, 6, 7, 5 };
		// Sorted array
		for (int i = 0; i < l.length; i++) {
			for (int j = 1; j < l.length; j++) {
				if (l[j - 1] > l[j]) {
					int k = l[j];
					l[j] = l[j - 1];
					l[j - 1] = k;
				}
			}
		}
		Arrays.stream(l).forEach(System.out::print);
		int k = 1;
		System.out.println();
		System.out.println(binarySearch(l, l.length - 1, 0, k));
	}
	private static int binarySearch(int[] arr, int end, int start, int search) {
		if (end > start) {
			int mid = (start + end) / 2;
			if (arr[mid] == search) {
				return mid;
			}
			if (search > arr[mid]) {
				return binarySearch(arr, end, mid + 1, search);
			}
			else if (search < arr[mid]) {
				return binarySearch(arr, mid, start, search);
			}
		}
		return -1;
	}

}
