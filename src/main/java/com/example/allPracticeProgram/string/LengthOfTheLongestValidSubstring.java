package com.example.allPracticeProgram.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfTheLongestValidSubstring {

	public static void main(String[] args) {
		String word = "cbaaaabc";
		String[] forbidden = { "aaa", "cb" };
//		String word = "leetcode";
//		String[] forbidden = { "de","le","e" };
		System.out.println("outputb : " + longestValidSubstring(word, Arrays.asList(forbidden)));
	}
	
	
	public static int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> invalid = new HashSet<>();
        for(String currWord: forbidden){
            invalid.add(currWord);
        }

        int ans = 0;
        int currRight = word.length()-1;

        for(int left = word.length()-1;left>=0;left--){
            for(int right = left; right<=Math.min(left+10, currRight);right++){
                String curr = word.substring(left, right+1);
                if(invalid.contains(curr)){
                    currRight = right-1;
                }
            }
            ans = Math.max(ans, currRight-left+1);
        }
        return ans;
    }

//	public static int longestValidSubstring(String word, List<String> forbidden) {
//		Set<String> set = new HashSet<String>();
//		int max = 0;
//		for (int i = 0; i < word.length(); i++) {
//			for (int j = i + 1; j <= word.length(); j++) {
//				String subStr = word.substring(i, j);
//				int count = 0;
//				for (String forb : forbidden) {
//					if (!subStr.contains(forb)) {
//						count++;
//					}
//				}
//
//				if (count == forbidden.size()) {
//					set.add(word.substring(i, j));
//					max = Math.max(max, word.substring(i, j).length());
//				}
//
//			}
//		}
//
//		set.forEach(System.out::println);
//		return max;
//	}
	
	
	
}
