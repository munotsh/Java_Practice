package com.example.allPracticeProgram.array;

public class MaxNDigitSum {

	public static void main(String[] args) {
		int ndigit=2;
		int sum=5;
		int end=sum*10;
		int start=10*(ndigit-1);
		
		for (int i=start;i<=end;i++) {
			int j=i;
			int sumk=0;
			while(j>0) {
				sumk= sumk+(j%10);
				j=j/10;
			}
			if (sumk==sum) {
				System.out.println("number : "+i);
			}
		}
		
		
	}

}
