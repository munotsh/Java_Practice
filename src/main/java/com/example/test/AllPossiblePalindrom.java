package com.example.test;

import java.util.HashSet;
import java.util.Set;

public class AllPossiblePalindrom {

	public static void main(String[] args) {
//		String str = "aabbbaa";
		String str = "google";
        int len = str.length();  
        Set<String> arr = new HashSet<String>();

        for(int i = 0; i < len; i++) {  
            for(int j = i; j < len; j++) {  
            	StringBuffer sb = new StringBuffer(str.substring(i, j+1));
            	if(sb.toString().equals(sb.reverse().toString()) && sb.toString().length() > 1 ) {
            		arr.add(sb.toString());  
            	}
            }  
        }  

        System.out.println("All subsets for given string are: ");  
        for(String s:arr) {  
            System.out.println(s);  
        }  
    }  

}

