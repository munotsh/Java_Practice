package com.example.allPracticeProgram.jpmc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEachWordStartingWithUpperCase {

	public static void main(String[] args) {
		String[] arr = "shailesh.A12_345.Munot_123@Gmail.com/cap?Pass word=abc".split("[^a-zA-Z0-9_]");
		Pattern p =Pattern.compile("[A-Z][\\w]+");
		for(String s:arr) {
		Matcher m = p.matcher(s);
		if(m.find() && s.contains("_"))
			System.out.println(s+"----"+m.group());
		}
	}
}
