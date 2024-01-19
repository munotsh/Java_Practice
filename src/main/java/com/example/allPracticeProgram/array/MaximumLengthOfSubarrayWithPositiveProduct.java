package com.example.allPracticeProgram.array;

public class MaximumLengthOfSubarrayWithPositiveProduct {

	public static void main(String[] args) {
		int[] nums = { 1, -2, -3, 4 };
//		int[] nums = { 0, 1, -2, -3, -4 };
//		int[] nums = { -1, -2, -3, 0, 1 };

		System.out.println("output = " + getMaxLen(nums));

	}

	public static int getMaxLen(int[] nums) {
//		int max = 0;
//		int maxProduct = 0;
//		int maxNoOfEle = 0;
//		for (int i = 0; i < nums.length; i++) {
//			int product = 1;
//			int numberOfElement = 0;
//			if (nums[i] != 0) {
//				for (int j = i; j < nums.length; j++) {
//
//					product = product * nums[j];
//					numberOfElement++;
//					if (product > 0) {
//						maxProduct = Math.max(maxProduct, product);
//						if (max < maxProduct) {
//							maxNoOfEle = Math.max(maxNoOfEle, numberOfElement);
//						}
//					}
//				}
//		}
//
//		return maxNoOfEle;
		
		int max = 0;
		int num_from_beginning = 0;
		int num_from_first_negative = 0;
		boolean is_even_negatives = true;
		
		for(int num: nums) {
			
			num_from_beginning++;
			
			if(num>0) {
				num_from_first_negative = num_from_first_negative == 0?0:num_from_first_negative+1;
			}
			else if(num<0) {
				num_from_first_negative++;
				is_even_negatives = !is_even_negatives;
			}
			else {
				
				num_from_first_negative = 0;
				num_from_beginning = 0;
				is_even_negatives = true;	
			}
			max = Math.max(max, is_even_negatives?num_from_beginning:num_from_first_negative-1);	
		}
		
		
		return max;
	}

}
