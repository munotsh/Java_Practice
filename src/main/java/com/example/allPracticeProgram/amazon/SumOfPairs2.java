package com.example.allPracticeProgram.amazon;

import java.util.Arrays;

public class SumOfPairs2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,5,9,4,8,2 };
		//int[] arr = { 6,6,3,9,3,5,1 };
		hasArrayTwoCandidates(arr,arr.length,17);

	}

	static void hasArrayTwoCandidates(int[] A, int arr_size, int sum) {
		// TODO Auto-generated method stub
		Arrays.parallelSort(A);
		int start=0;
		int end=arr_size-1;
		while(start<end) {
			if(A[start] + A[end] == sum) {
				System.out.println(A[start]+ " = " + A[end]);
				start++;
				end--;
			}
			else if(A[start] + A[end] < sum)
				start++;
			else
				end--;	
		}
		
	}

}
