package com.example.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialWordInRegEx {

	public static void main(String[] args) {
		Pattern p = Pattern.compile(".");
		Matcher m = p.matcher("abc ABC 123 !@#");
		while (m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}

	}

}
