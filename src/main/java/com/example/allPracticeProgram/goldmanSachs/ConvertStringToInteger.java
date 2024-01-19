package com.example.allPracticeProgram.goldmanSachs;

public class ConvertStringToInteger {

	public static void main(String[] args) {

		
		int result = cStoI("123");
		if(result == 123) {
			System.out.println("yes");
		}
		else {
			System.out.println("No");
		}
	}

	private static int cStoI(String str) {
		int result =0;
		int c = 1;
		for(int i=str.length()-1;i>=0;i--) {
			result = result + ((str.charAt(i)-48)*c);
			c =c*10;
		}
		System.out.println(result);
		return result;
	}
	


}
