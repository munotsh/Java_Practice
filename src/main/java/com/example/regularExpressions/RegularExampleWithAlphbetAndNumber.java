package com.example.regularExpressions;

public class RegularExampleWithAlphbetAndNumber {

	public static void main(String[] args) {

		String s = "I am Shilesh Munot, my emailId is Shailesh.munot@gmail.com and userId is: Shailesh_Munot";

		String[] array = s.split("[^a-zA-Z0-9_]");
		for(String ss:array) {
			System.out.println(ss);
		}
	}

}
