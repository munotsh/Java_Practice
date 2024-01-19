package com.example.allPracticeProgram.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllTxtfiles {
	public static void main(String[] args) {
		String[] arr = {"12ab.txt","jb.kl1.bat","db_12.txt","df43.docs"};
		Pattern p = Pattern.compile("[a-zA-Z0-9_]*[.]txt");
		for(String s:arr) {
		Matcher m= p.matcher(s);
		if(m.find()) {
			System.out.println(s);
		}
		}
	}
}
