package com.example.allPracticeProgram.cisco;

public class DubleBasePalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num =5;
		StringBuffer sb;
		int sum =0;
		for(int i=1; i<=5;i++) {
			sb = new StringBuffer(i+"");
			int reversedNumber = Integer.parseInt(sb.reverse().toString());
			if(reversedNumber == i) {
				System.out.println(i);
				String binary = Integer.toBinaryString(i);
				System.out.println(binary);
				sb = new StringBuffer(binary);
//				System.out.println(sb.reverse());
				if(binary.equals(sb.reverse().toString())) {
					sum+=i;
				}				
			}
			System.out.println(sum);
		}
	}

}
