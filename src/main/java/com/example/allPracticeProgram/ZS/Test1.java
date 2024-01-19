package com.example.allPracticeProgram.ZS;

public class Test1 {

	public static void main(String[] args) {
		String s= "shailesh";
		StringBuffer sb = new StringBuffer();
		while(s.length()>0) {
			int len  = s.length();
			int len2 = s.replace(s.charAt(0)+"", "").length();
			sb.append(s.charAt(0)+""+(len-len2));
			s = s.replace(s.charAt(0)+"", "");
		}
		System.out.println(sb.toString());

	}

}
