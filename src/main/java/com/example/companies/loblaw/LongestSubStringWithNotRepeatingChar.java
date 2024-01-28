package com.example.companies.loblaw;

import java.util.*;

public class LongestSubStringWithNotRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabcbb"; // output : 3
//        String s = "bbbbb"; // output : 1
//        String s = "pwwkew"; // output : 3
// easy to understand
        System.out.println(lengthOfLongestSubstringWithSet(s));
        //Sliding window approach
        System.out.println(lengthOfLongestSubstringWithSlidingWindow(s));
        //difficult to understand
        System.out.println(lengthOfLongestSubstringWithMap(s));
    }

    private static int lengthOfLongestSubstringWithSet(String s) {
        if (s == null && s.length() == 0)
            return 0;

        int left = 0;
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }
        }
        return max;
    }

    private static int lengthOfLongestSubstringWithSlidingWindow(String s) {
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        List<Character> list = new ArrayList<>();
        while (end < s.length()) {
            if (list.contains(s.charAt(end))) {
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            } else {
                list.add(s.charAt(end));
                max = Math.max(max, list.size());
                end++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstringWithMap(String s) {
        int len = s.length(), ans = 0;
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (ht.containsKey(s.charAt(j)))
                i = Math.max(ht.get(s.charAt(j)), i);
            ans = Math.max(ans, j - i + 1);
            ht.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
