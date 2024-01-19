package com.example.allPracticeProgram.customeSemaphore;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 9, 4, 8, 2 };
		hasArrayTwoCandidates(arr, arr.length, 17);
	}
	static void hasArrayTwoCandidates(int A[], int arr_size, int sum) {
		Arrays.sort(A);
		int start = 0;
		int end = arr_size - 1;
		while (start < end) {
			if (A[start] + A[end] == sum) {
				System.out.println(A[start] + " = " + A[end]);
				start++;
				end--;
			} else if (A[start] + A[end] < sum)
				start++;
			else
				end--;
		}
	}
}
