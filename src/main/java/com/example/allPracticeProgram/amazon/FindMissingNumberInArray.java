package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMissingNumberInArray {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 3, 7, 8, 5 };
//		int[] arr = { 1, 2, 3, 5 };
//		int[] arr = { 6,1,2,8,3,4,7,10,5 };
//		
		int first = arr[0];
		int last = arr.length+1;
		int totalSum = last*(last+1)/2;
		int arrSum = Arrays.stream(arr).sum();
		System.out.println(totalSum-arrSum);
	}
}
