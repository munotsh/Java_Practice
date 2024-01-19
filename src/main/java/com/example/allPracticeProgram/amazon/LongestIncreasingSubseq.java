package com.example.allPracticeProgram.amazon;

import java.util.Arrays;
import java.util.TreeSet;

public class LongestIncreasingSubseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,1,5};
		System.out.println(lengthOfLIS(a));
	//	System.out.println(lenLIS(a));
		
		
	}
	public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i < n; i++){
            for(int j=0; j <= i-1; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
//	public static int lenLIS(int[] nums) {
//		TreeSet<Integer> set = new TreeSet<>();
//        if(nums == null || nums.length == 0)
//            return 0;
//        set.add(nums[0]);
//        for(int i=0;i<nums.length;i++){
//            int num = nums[i];
//            Integer nextNum = set.ceiling(num);
//            if(nextNum == null || num > nextNum){
//                set.add(num);
//            }
//            else{
//                set.remove(nextNum);
//                set.add(num);
//            }
//        }
//        return set.size();
//	}
}
