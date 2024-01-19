package com.example.allPracticeProgram.common;

import java.util.Map;
import java.util.WeakHashMap;

public class Test1 {
	static int a=0;
	
	static{
		a++;
		
	}
	public Test1(){
		
	}
	public void m2(){
		
		
	}
	public static void main(String[] args) {
//		int x = 10;
//		int y = 2;
//		try {
//			for (int i = 2; i >= 0; i--) {
//				int ans = x / i;
//				System.out.println(ans + " ");
//			}
//		} catch (Exception e) {
//			System.out.println("E1");
//		} catch (ArithmeticException e) {
//			System.out.println("E1");
//		}
		
		Map<String,Integer> wm = new WeakHashMap<>();
		String s1 ="Shailesh";
		String s2 ="Neha";
		String s3 ="Vaibhav";
		String s4 ="Gaurav";
		wm.put(s1,1);
		wm.put(s2,2);
		wm.put(s3,3);
		wm.put(s4,4);
		System.out.println(wm);
		s1=null;
		s2=null;
		System.gc();
		System.out.println(wm);

	}

}
