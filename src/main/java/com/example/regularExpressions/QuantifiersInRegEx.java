package com.example.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersInRegEx {

	public static void main(String[] args) {
		
		System.out.println("*************   a  **********");
		Pattern p = Pattern.compile("a");
		Matcher m = p.matcher("abaabaaab");
		while(m.find()) {
			System.out.println(m.start()+"...."+m.group());
		}
		
		System.out.println("*************   a+  **********");
		Pattern p1 = Pattern.compile("a+");
		 m = p1.matcher("abaabaaab");
		while(m.find()) {
			System.out.println(m.start()+"...."+m.group());
		}
		
		System.out.println("*************   a?  **********");
		Pattern p2 = Pattern.compile("a?");
		m = p2.matcher("abaabaaab");
		while(m.find()) {
			System.out.println(m.start()+"...."+m.group());
		}
		
		System.out.println("*************   a*  **********");
		Pattern p3 = Pattern.compile("a*");
		m = p3.matcher("abaabaaab");
		while(m.find()) {
			System.out.println(m.start()+"...."+m.group());
		}
		
		
		
	}

}
