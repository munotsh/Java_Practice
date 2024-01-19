package com.example.allPracticeProgram.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidation {
//Mobile number should contain 10 digit only
	// the first digit should be 7 or 8 or 9

	public static void main(String[] args) {
		Pattern p = Pattern.compile("[7-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		Matcher m = p.matcher("8234567890");
//		while (m.find()) {
//			System.out.println(m.group());
//		}
//
//		p = Pattern.compile("[789][0-9]{9}");
//		m = p.matcher("8234567890");
//		while (m.find()) {
//			System.out.println(m.group());
//		}
//		
//		p = Pattern.compile("[7-9][0-9]{9}");
//		m = p.matcher("8234567890");
//		while (m.find()) {
//			System.out.println(m.group());
//		}
		
		p = Pattern.compile("0?[7-9][0-9]{9}");
		m = p.matcher("08234567890");
		while (m.find()) {
			System.out.println(m.group());
		}
		
		p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		m = p.matcher("918234567890");
		while (m.find() && m.group().equals("918234567890")) {
			System.out.println(m.group());
		}
	}

}
