package com.example.test;

import java.util.Stack;

public class IsValidString {
	static boolean isValid(String s) {
        Stack<Character> st =  new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }else if(st.peek() == c){
                st.pop();
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
	public static void main(String[] args) {

		System.out.println(isValid(""));
        System.out.println(isValid("vv"));
        System.out.println(isValid("xbbx"));
        System.out.println(isValid("bbccdd"));
        System.out.println(isValid("xyffyxdd"));
        
       System.out.println(isValid("xyx"));
       System.out.println(isValid("yx")); 
       System.out.println(isValid("y"));  
       System.out.println(isValid("xxxyyxx"));   
	}
}
