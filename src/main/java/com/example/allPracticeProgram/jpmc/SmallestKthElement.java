package com.example.allPracticeProgram.jpmc;

import java.util.Arrays;

public class SmallestKthElement {

	public static void main(String[] args) {

		int[] arr = { 2, 4, 1, 5, 2, 7, 8, 4, 9, 13 };
		int k = 2;
		int[] arr2 = Arrays.stream(arr).distinct().sorted().limit(k).toArray();
		if (arr2.length >= k) {
			System.out.println(arr2[k - 1]);
		} else {
			System.out.println("null");
		}
	}

}
