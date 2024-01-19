package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSumConsecutiveDigitsArray {
	public static void main(String[] args) {
		int[] numArr = { 1, 2, 3, 7, 3, 5 };
		System.out.println("Max sum using 3 consecutive integers :" + maxSum(numArr, 3));
	}
	public static int maxSum(int[] numArr, int k) {
		List<Integer> intList = Arrays.stream(numArr).boxed().collect(Collectors.toList());
		int max = 0;
		int len = 0;
		for (int i = 0; i <= numArr.length - k; i++) {
			int intSum = intList.stream().skip(i).limit(k).mapToInt(Integer::intValue).sum();
			if (max < intSum) {
				len = intList.stream().skip(i).limit(k).collect(Collectors.toSet()).size();
				max = intSum;
			}
		}
		if (k == len) {
			return max;
		} else {
			return -1;
		}
	}
}
