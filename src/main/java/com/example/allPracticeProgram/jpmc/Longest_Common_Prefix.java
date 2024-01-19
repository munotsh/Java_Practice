package com.example.allPracticeProgram.jpmc;

public class Longest_Common_Prefix {
	
	public static void main(String[] args) {
//		  String[] strs = {"techie delight", "tech", "techie",
//	                "technology", "technical"};
//		  
		String[] strs = {"Echo", "Alexa", "Kindle", "Echo Show", "Amazon"};
	        System.out.println("The longest common prefix is " + longestCommonPrefix(strs));
	        
		}
	
	  public static String longestCommonPrefix(String[] strs) {
	        if (strs.length == 0) return "";
	        String prefix = strs[0];
	        for (int i = 1; i < strs.length; i++)
	            while (!strs[i].contains(prefix)) {
	                prefix = prefix.substring(0, prefix.length() - 1);
	                if (prefix.isEmpty()) return "";
	            }
	        return prefix;
	    }
}
