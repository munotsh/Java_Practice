package com.example.allPracticeProgram.amazon1;

public class KadanesAlgoritumToFindMaximumsumSubArray {

	public static void main(String[] args) {
		int[] arr = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 2, 1 };

		int maxSoFar = arr[0];
		int maxEnd = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < arr.length; i++) {
			maxEnd = maxEnd + arr[i];
			if (maxSoFar < maxEnd) {
				maxSoFar = maxEnd;
				start = s;
				end = i;
			}
			if (maxEnd < 0) {
				maxEnd = 0;
				s = i + 1;
			}
		}
		System.out.println(maxSoFar);
		System.out.println(start + " to " + end);
	}
}
