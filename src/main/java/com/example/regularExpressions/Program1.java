package com.example.regularExpressions;

public class Program1 {

	public static void main(String[] args) {
		String[] arr = "Neha Shailesh Munot".split("[\\s]");
		for(String s:arr) {
//			System.out.println(s);
		}
		
		arr = "Neha Shailesh Munot".split("[a]");
		for(String s:arr) {
			System.out.println(s);
		}
		
		arr = "Neha Shailesh Munot".split("[a\\s]");
		for(String s:arr) {
			System.out.println(s);
		}
		
		System.out.println("..................");
		arr = "www.NehaShaileshMunot.com".split("[.]");
		for(String s:arr) {
			System.out.println(s);
		}
		System.out.println("..................");
		arr = "www.NehaShaileshMunot.com".split("\\.");
		for(String s:arr) {
			System.out.println(s);
		}
	}

}
