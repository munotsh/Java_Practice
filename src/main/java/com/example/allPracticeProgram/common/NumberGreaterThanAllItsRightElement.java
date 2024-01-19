package com.example.allPracticeProgram.common;

public class NumberGreaterThanAllItsRightElement {

	public static void main(String[] args) {
		int[] arr = { 6, 3, 2, 5, 4 };
		int max = arr[arr.length - 1];
		System.out.println(max);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				System.out.println(max);
			}
		}
	}

}
