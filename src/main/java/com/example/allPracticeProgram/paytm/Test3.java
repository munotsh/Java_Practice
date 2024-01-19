package com.example.allPracticeProgram.paytm;

import java.util.Arrays;
import java.util.Collections;

public class Test3 {

	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 7, 6 };
		int max = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			for(int j =1;j<=arr[i];j++) {
				int x = arr[i] - 1;
				arr[i - 1] = arr[i - 1] + x;
				arr[i] = arr[i] - x;
				max = Math.min(max, Collections.max(Arrays.asList(arr)));	
			}
			
		}
		System.out.println(max);
	}

}
