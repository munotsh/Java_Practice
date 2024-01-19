package com.example.allPracticeProgram.cisco;

public class Solution {
	 public static int countSubstrings(String s) {
	        
	        int res = 0;
	        for (int i = 0; i < s.length(); i++) {
	            res += helper(s, i, i) + helper(s, i, i + 1); 
	        }
	        return res;
	        
	    }
	    
	    private static int helper(String s, int start, int end) {
	        if (start < 0 || end > s.length() - 1) {
	            return 0;
	        }
	        if (s.charAt(start) == s.charAt(end)) {
	            return helper(s, start - 1, end + 1) + 1;
	        }
	        
	        return 0;
	    }
	    
	    
	    public static void main(String[] args) {
			System.out.println(countSubstrings("aaa"));
			System.out.println(countSubstrings("tacocat"));
			
		}
}
