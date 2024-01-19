package com.example.allPracticeProgram.SlidingWindowAlgorithmPatterns;

public class FindSubArrayWithGivenTargetedSum {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
		int targetedSum = 7;
		FindSubArrayOfDesireSum(arr, targetedSum);
	}

	private static void FindSubArrayOfDesireSum(int[] arr, int targetedSum) {
		int sum = 0;
		for (int i = 0, j = 0; i < arr.length;i++) {
			sum = sum + arr[i];
			if (sum == targetedSum) {
				for (int k = j; k <= i; k++) {
					System.out.print(arr[k]);
				}
				System.out.println();
			}
			if (sum >= targetedSum) {
				sum = 0;
				j++;
				i = j - 1;
			}
		}
	}

}
