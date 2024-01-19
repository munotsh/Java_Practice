package com.example.allPracticeProgram.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindMobileNumberFromString {

	public static void main(String[] args) {
		String str = "this is Shailesh with mobile number with 8888425725 and email shailesh.munot@gmail.com"
				+ " and Neha with mobile number 8643219057 and email with neha.meher@gmail.com";
		Pattern p =Pattern.compile("(0|91)?[789][0-9]{9}");
		Matcher m = p.matcher(str);
		while(m.find()) {
			System.out.println(m.group());
		}
		p = Pattern.compile("[a-zA-Z0-9._]*@[a-zA-Z0-9]+[.][a-zA-Z0-9]+");
		m = p.matcher(str);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

}
