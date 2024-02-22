package com.example.strings;

public class FindLongestVowelSubsequence {
    public static void main(String[] args) {
        String str = "aeiaaioooaaeeuuaeiou";
        System.out.println(longestSubSeqOfVowels(str));
    }

    private static String longestSubSeqOfVowels(String str) {
        StringBuffer sb = new StringBuffer();
        String result = "";
        char lastChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (sb.length()>0 && ch<lastChar){
                if(result.length() < sb.length()){
                    result = sb.toString();
                }
                sb = new StringBuffer();
                i--;
            }else {
                sb.append(ch);
                lastChar = ch;

            }
        }
        return result.length()<sb.length()?sb.toString():result;
    }
}
