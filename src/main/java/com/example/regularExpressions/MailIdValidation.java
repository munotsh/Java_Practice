package com.example.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailIdValidation {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)");
//		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher("Shailesh.munot@xxx.com");
		while(m.find()) {
			System.out.println(m.group());
		}
	}

}
