package com.example.Array;

public class MinMove {

	public static void main(String[] args) {
		// int[] a = {1,1,3,4,4,4};
		// int[] a = {1,2,2,2,5,5,5,8};
		int[] a = { 1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4 };
		//OP:5
//		int[] a = {10,10,10};
		//OP:3
		System.out.println(minMoves(a));
	}

	public static int minMoves(int[] data) {
		int minOperations = 0;
		for (int i = 0, j = 0; i < data.length; i = j) {
			while (j < data.length && data[i] == data[j])
				j++;
			int frequency = j - i;
			minOperations += Math.min(Math.abs(data[i] - frequency), frequency);
		}
		return minOperations;
	}
}
