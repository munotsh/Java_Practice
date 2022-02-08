package com.example.test;

import java.util.Arrays;

public class DutchNationalFlagAlgo {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 0, 1, 0, 1, 2, 0, 2 };
		
		int start;
		int end = arr.length - 1;
		int mid = start = 0;
		int temp;
		while (mid <= end) {
			switch (arr[mid]) {
			case 0:
				temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;
				start++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
				break;
			default:
				break;
			}
		}
		Arrays.stream(arr).forEach(i -> System.out.println(i));
	}
}
