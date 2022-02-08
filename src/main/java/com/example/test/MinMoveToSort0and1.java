package com.example.test;

public class MinMoveToSort0and1 {

	public static int NumberOfswap(int[] arr, int k) {
		int low, high, swap;
		low = swap = high = 0;
		while (high < arr.length) {
			if (arr[high] == k) {
				swap += high - low;
				low += 1;
			}
			high += 1;
		}
		return swap;
	}
	
	public static void main(String[] args) {
//		int[] arr = {0,1,0,1};
//		int[] arr = { 1, 1, 0, 1 }
		int[] arr = {0,1,0,1,0,1,0,1};
		System.out.println(Math.min(NumberOfswap(arr, 0), NumberOfswap(arr, 1)));
	}
}
