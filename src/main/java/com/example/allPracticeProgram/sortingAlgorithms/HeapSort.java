package com.example.allPracticeProgram.sortingAlgorithms;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 5, 12, 64, 1, 37, 90, 91, 97 };
		heapify(arr, arr.length-1);
		heapSort(arr,0,arr.length-1);
	}

	private static void heapSort(int[] arr, int start,int end) {
	for(int i = end;i>=0;i--) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		heapify(arr,i-1);
	}
	System.out.println("result = ");
	Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
	}

	private static void heapify(int[] arr, int last) {

		for (int i = last; i >= 0; i--) {

			int parent = (i-1)/ 2;
			int left = parent *2 +1;
			int right = parent *2 +2;
			int max = Math.max(left, right);
			
			if(arr[left] > arr[right])
				i = left;
			else
				i = right;
			
			if (arr[i] > arr[parent]) {
				int temp = arr[i];
				arr[i] = arr[parent];
				arr[parent] = temp;
			}
			if(i==parent)
			heapify(arr, last-1);

		}
		
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}
//{ 5, 12, 64, 97, 37, 90, 91, 1 };
	// { 5, 12, 91, 97, 37, 90, 64, 1 };
	
	// { 5, 90, 91, 97, 37, 12, 64, 1 };
	// {37, 90, 91, 97, 5, 12, 64, 1 };
	// {37, 90, 91, 97, 5, 12, 64, 1 };
	// {37, 90, 91, 97, 5, 12, 64, 1 };
	// {37, 90, 91, 97, 5, 12, 64, 1 };
	// {97, 90, 91, 37, 5, 12, 64, 1 };
	// {97, 90, 91, 37, 5, 12, 64, 1 };
	
}
