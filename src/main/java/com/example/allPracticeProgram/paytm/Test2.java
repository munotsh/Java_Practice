package com.example.allPracticeProgram.paytm;

import java.util.Arrays;

public class Test2 {
	public static int maximizeFinalElement(int arr[], int n) {

// Sort the array elements
// in ascending order
		Arrays.sort(arr);

// If the first element is
// is not equal to 1
		if (arr[0] != 1)
			arr[0] = 1;

// Traverse the array to make
// difference between adjacent
// elements <=1
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] > 1) {
				arr[i] = arr[i - 1] + 1;
			}
		}
		return arr[n - 1];
	}

//Driver Code
	public static void main(String[] args) {
//		int n = 4;
//		int arr[] = { 1, 5, 7, 6 };

		int n = 3;
		int arr[] = { 5, 15, 19 };
		int max = maximizeFinalElement(arr, n);
		System.out.print(max);
	}

}
