package com.example.allPracticeProgram.MorganStanley;

import java.util.Arrays;

public class MSTest {

//	public static int lengthOfLIS(int[] nums) {
//		int memo[][] = new int[nums.length + 1][nums.length];
//		for (int[] l : memo) {
//			Arrays.fill(l, -1);
//		}
//		return lengthofLIS(nums, -1, 0, memo);
//	}
//
//	public static int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
//		if (curpos == nums.length) {
//			return 0;
//		}
//		if (memo[previndex + 1][curpos] >= 0) {
//			return memo[previndex + 1][curpos];
//		}
//		int taken = 0;
//		if (previndex < 0 || nums[curpos] > nums[previndex]) {
//			taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
//		}
//
//		int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
//		memo[previndex + 1][curpos] = Math.max(taken, nottaken);
//		return memo[previndex + 1][curpos];
//	}

	public static int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		for (int i = 1; i < dp.length; i++) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] = { 1, 4, 3 };
		System.out.print(lengthOfLIS(s));
	}

}
