package com.example.allPracticeProgram.jpmc;

public class Longest_Common_subString_suffix_and_prefix {

	public static void main(String[] args) {
		String[] suf = { "Gloucestershire", "Hampshire", "Yorkshire", "Lancashire" };
		System.out.println("The longest common suffix is " + longestCommonSuffix(suf));
		
		  String[] pre = {"techie delight", "tech", "techie",
	                "technology", "technical"};
	        System.out.println("The longest common prefix is " + longestCommonPrefix(pre));
	        
//	        String[] logestSubString = {"grace", "graceful", "disgraceful",
//	                "gracefully"};
	        String[] logestSubString = {"OldSite:GeeksforGeeks.org","NewSite:GeeksQuiz.com"};
	        System.out.println("The longest common longestCommonSubString is " + longestCommonSubString(logestSubString));

	}

	private static String longestCommonSubString(String[] strs) {
		int n = strs.length;

		String s = strs[0];
		int len = s.length();
		String res = "";
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String stem = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++) {
					if (!strs[k].contains(stem)) {
						break;
					}
				}
				if (k == n && res.length() < stem.length())
					res = stem;
			}
		}

		return res;
	}

	public static String longestCommonSuffix(String[] strs) {

		if (strs.length == 0)
			return "";
		String suffix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (!strs[i].contains(suffix)) {
				suffix = suffix.substring(1, suffix.length());
				if (suffix.isEmpty())
					return "";
			}
		}
		return suffix;
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
