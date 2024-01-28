package com.example.allPracticeProgram.goldmanSachs;

public class SecondMaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr = {3,2,4,6,10,1};
		int[] arr = {9,2,8,3,5,4};
//		int[] arr = {9,9,9,9,9};

int secondMax = findSecondMaxNumber(arr);

		if(secondMax == Integer.MIN_VALUE){
			System.out.println("no second max value");
		}
		else{
			System.out.println("second max value"+secondMax);
		}
	}

	private static int findSecondMaxNumber(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for(int i:arr){
			if(i > max){
				secondMax = max;
				max = i;
			}
			else if(i>secondMax && i!=max){
				secondMax = i;
			}
		}
		return secondMax;
	}

}
