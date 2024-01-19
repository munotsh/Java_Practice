package com.example.allPracticeProgram.jpmc;

public class ChecksumNumber {
	public static void main(String[] args) {
//		int num=1496;
		int num=5678;
//		int num=149623;
		int sum = 0;
		while(num>0) {
			int firstlastDigit=num%10;
//			System.out.println(firstlastDigit);
			sum = sum + firstlastDigit;
			int SecondlastDigit=((num/10)%10);
//			System.out.println(SecondlastDigit);
			num = (num/10)/10;
			SecondlastDigit = SecondlastDigit+SecondlastDigit;
			if(SecondlastDigit>9) {
				while(SecondlastDigit>0) {
					int innerLastDigit = (SecondlastDigit%10);
//					System.out.println(innerLastDigit);
					sum = sum+innerLastDigit;
					SecondlastDigit = (SecondlastDigit/10);	
				}
			}
//			System.out.println(SecondlastDigit);
			sum =sum +SecondlastDigit;
		}
		System.out.println("sum =  "+sum);
	}

}
