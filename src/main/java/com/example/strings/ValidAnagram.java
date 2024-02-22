package com.example.strings;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        //simple solution
        System.out.println(obj.isAnagram1("anagram", "nagaram"));
        System.out.println(obj.isAnagram1("rat", "cat"));

        // bit difficult
        System.out.println(obj.isAnagram2("anagram", "nagaram"));
        System.out.println(obj.isAnagram2("rat", "cat"));

        // checking by counter of charachter one will increment and other one will decrement
        System.out.println(obj.isAnagramCounting("anagram", "nagaram"));
        System.out.println(obj.isAnagramCounting("rat", "cat"));
    }

    public boolean isAnagram1(String s, String t) {
//        TC : more than N because of sort and toString function
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.toString(sArr).equals(Arrays.toString(tArr));
    }

    public boolean isAnagram2(String s, String t) {
//        TC : O(logn)
        if(s == null || t == null) return false;
        s = s.toLowerCase();
        t = t.toLowerCase();
        int sLen = s.length();
        int tLen = t.length();
        boolean result = true;
        if (sLen != tLen) return false;
        while (sLen == tLen && (sLen != 0 || tLen != 0)) {
            char ch =s.charAt(0);
            s = s.replaceAll(ch+"","");
            t = t.replaceAll(ch+"","");
            sLen = s.length();
            tLen = t.length();
            if (sLen != tLen) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
