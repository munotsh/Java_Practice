package com.example.allPracticeProgram.morgan_stanley;

public class ArrayGame {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
//int[] nums = {3,4,6,6,3};
int[] nums = {5,6,8,8,5};
		for (int i=0; i<nums.length; i++) {
			int num = nums[i];
			if (num < min) {
				min = num;
			}
		}

		int diff = 0;
		for (int i=0; i<nums.length; i++) {
			diff += nums[i] - min;
		}
		
		System.out.println(diff);
	}

}
