package com.example.allPracticeProgram.common;
public class StringEqualsMultiple {
	public static void main(String[] args) {
		String s = "abcdabcdabcdabcdabcdabcd";
		String m = "abcdabcdabcd";
		System.out.println(getLength(s,m));
//		int len = s.replace(m, "").length();
//		if (len == 0) {
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < m.length(); i++) {
//				sb.append(m.charAt(i));
//				if (s.replace(sb.toString(), "").length() == 0) {
//					System.out.println(sb.length());
//					break;
//				}
//			}
//		} else {
//			System.out.println("No");
//		}
	}
	
	private static int getLength(String s, String t) {
		if(s.length() % t.length() > 0)
			return -1;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i*t.length() < s.length();i++) {
			sb.append(t);
		}
		if(!sb.toString().equals(s))
			return -1;
			
		int divisible = 1;
		//int a = 0;
		
		for(int i=1;i<=t.length();i++) {
		    
		    //optimized solution for skipping a few unrequired iterations
		   if(t.length()%divisible++ != 0) {
		        continue;
		    }
		     
		     
			sb = new StringBuilder();
			String subStr = t.substring(0, i);
			while(sb.length() < t.length()) {
			 //	System.out.println(a++);
				sb.append(subStr);
			}
			if(sb.toString().equals(t))
				return i;
		}
		return -1;
	}
}
