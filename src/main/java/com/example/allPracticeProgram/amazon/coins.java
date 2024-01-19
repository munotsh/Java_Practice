package com.example.allPracticeProgram.amazon;

public class coins {

	public static void main(String[] args) {
//		Given the initial sequence of a coins, find the minimum number of coins 
//		that can be flipped to obtain a beautiful sequence.
//		All head facing coins or tails facing coins sequence is also valid.
		
		String s = "THHHTH";		
//		String s = "HHTHTT";
		int min_flips = s.replace("T", "").length();
		int curr_flips = min_flips;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'H') 
				curr_flips -=1;
			else
				curr_flips +=1;
			min_flips = Math.min(min_flips, curr_flips);
		}
		System.out.println(min_flips);
	}
}
