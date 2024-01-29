package com.example.strings;

/*Algorithem : Expand Around Center
* Intuition :
To enumerate all palindromic substrings of a given string, we first expand a
* given string at each possible starting position of a palindrome and also
* at each possible ending position of a palindrome and keep track of the length
* of the longest palindrome we found so far.
* o(n^2)
* */

public class LongestPalindromeString {
    public static void main(String[] args) {
        String str = "abababa";
        //Algorithm : Expand Around Center (easy to understand)
        //O(n^2)
        System.out.println(findLongestPalindromeString(str));
        // Algorithm : Manacher's Algorithm (more complex dot try in interview)
        //O(n)
//        System.out.println(findLongestPalindromeStringDontTryInInterview(str));
    }

    public static String findLongestPalindromeString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int subStringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int evenLength = expandFromCenter(s, i, i); // if the string is even it will have two center
            int oddLength = expandFromCenter(s, i, i + 1); // if the string is even it will have one center
            int maxLength = Math.max(evenLength, oddLength);
            if (maxLength > subStringLength) {
                start = i - (maxLength - 1) /2;
                subStringLength = maxLength;
            }
        }
        return s.substring(start,subStringLength);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


//    private static String findLongestPalindromeStringDontTryInInterview(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
//        int maxLen = 1;
//        String maxStr = s.substring(0, 1);
//        s = "#" + s.replaceAll("", "#") + "#";
//        int[] dp = new int[s.length()];
//        int center = 0;
//        int right = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (i < right) {
//                dp[i] = Math.min(right - i, dp[2 * center - i]);
//            }
//
//            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length()
//                    && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
//                dp[i]++;
//            }
//
//            if (i + dp[i] > right) {
//                center = i;
//                right = i + dp[i];
//            }
//
//            if (dp[i] > maxLen) {
//                maxLen = dp[i];
//                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
//            }
//        }
//
//        return maxStr;
//    }
}
