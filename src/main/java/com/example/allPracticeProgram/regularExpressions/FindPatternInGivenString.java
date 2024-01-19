package com.example.allPracticeProgram.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatternInGivenString {

	static int count =0;

	public static void main(String[] args) {
		Pattern p = Pattern.compile("ab");
		Matcher m =p.matcher("ababbaba");
		
		while(m.find()) {
			count++;
			System.out.println(m.start()+"...."+(m.end()-1)+"....."+m.group());
		}
		System.out.println(count);
	}

}

