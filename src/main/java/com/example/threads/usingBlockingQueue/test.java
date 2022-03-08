package com.example.threads.usingBlockingQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {

String s1 = "WESTERNUNION";



//for(int i =0;i<s1.length();i++) {
//int i=0;
//while(s1.length()>0) {
//	int len = s1.length();
//	
//	String s2 = String.valueOf(s1.charAt(i));
//	
//	s1 = s1.replace(s2,"");
//	
//	int len2 = s1.length();
//	
//	if(len-len2 == 1) {
//		System.out.println(s2);
//	}
//}


Map<Character, Integer> map = new HashMap<Character, Integer>();

//char[] d = s1.toCharArray();
int len = s1.length()-1;
while(len>=0) {
	Character ch = s1.charAt(len);
	if(map.containsKey(ch)) {
		map.put(ch, map.get(ch)+1);
	}else{
		map.put(ch,1);
	}
	len--;
}



//System.out.println(d);
System.out.println(map);







	}

}
