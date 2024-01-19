package com.example.allPracticeProgram.SlidingWindowAlgorithmPatterns;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calculate the maximum sum of subArray with window of 3
		int window = 3;
		int[] arr = { 4, 6, 3, 8, 1, 5 };
//		int[] arr = {1,2,3,4,5,6};
		System.out.println(calculateSubArryWithMaxSum(arr, window));
	}

	private static int calculateSubArryWithMaxSum(int[] arr, int window) {
		int sum = 0;
		int max = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < window) {
				sum = sum + arr[i];
				if(sum>max)
				{
					max = sum;
					j =i;
				}
			} else {
				int left = i - window;
				sum = (sum - arr[left]) + arr[i];
				if(sum>max)
				{
					max = sum;
					j =i;
				}
			}
		}
		for(int i = j-window+1;i<=j;i++) {
			System.out.println(arr[i]);
		}
		return max;
	}

}
