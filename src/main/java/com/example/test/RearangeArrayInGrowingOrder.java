package com.example.test;

import java.util.Arrays;

public class RearangeArrayInGrowingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 3, 5 };
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i] || (arr[i - 1] + 1) == arr[i]) {
				continue;
			} else {
				if (arr[i - 1] > arr[i])
					arr[i - 1] = arr[i - 1] - arr[i];
				else
					arr[i] = arr[i - 1] + 1;
			}
		}

		Arrays.stream(arr).forEach(i -> System.out.println(i));
	}

}
