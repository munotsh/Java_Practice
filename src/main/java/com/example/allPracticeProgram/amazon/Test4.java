package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l= new ArrayList<Integer>();
//		l.add(4);
//		l.add(3);
//		l.add(5);
//		l.add(4);
//		l.add(3);
		
//		l.add(2);
//		l.add(1);
//		l.add(3);
		
		l.add(4);
		l.add(2);
		l.add(3);
		l.add(1);
		
		System.out.println(countDecreasingRatings(l));

	}
	
	 private static long countDecreasingRatings(List<Integer> ratings){
	        if (ratings == null || ratings.size() == 0) {
	            return 0;
	        }

	        int[] dp = new int[ratings.size()];
	        dp[0] = 1;

	        for (int i = 1; i < ratings.size(); i++) {
	            if (ratings.get(i) == ratings.get(i - 1) - 1) {
	                dp[i] = dp[i - 1] + 1;
	            } else {
	                dp[i] = 1;
	            }
	        }

	        long res  = 0;
	        for (int cur : dp) {
	            res += cur;
	        }
	        return res;
	    }

}
