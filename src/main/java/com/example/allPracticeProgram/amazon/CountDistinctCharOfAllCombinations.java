package com.example.allPracticeProgram.amazon;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctCharOfAllCombinations {

	public static void main(String args[]) {
		System.out.println(countDistinct("good"));
	}

	public static int countDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0, sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// char at i contributes to all substrings S that end at
			// i minus number of substrings of S
			// which already counted char at i
			int tcount = i + 1 - map.getOrDefault(c, 0);
			count += sum + tcount;
			// sum of counts of previous chars
			sum += tcount;
			map.put(c, i + 1);
		}
		return count;
	}
}

//count : 4 8 16
//sum : 3 4 12 
// g,:1 o:2 o:3 d:4  