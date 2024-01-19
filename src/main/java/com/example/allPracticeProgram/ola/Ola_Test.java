package com.example.allPracticeProgram.ola;

public class Ola_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {5,10,80};
		int n=3;
		int init_S=1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>25 && arr[i]<60) {
				continue;
			}
			else if(arr[i]<=25 && init_S>=1) {
				if((init_S/2) >=1) {
					init_S= init_S/2;	
				}
				
			}
			else if(arr[i]>=60 ) {
				init_S = init_S *2;
			}
			
		}
		System.out.println(init_S);

	}
	

}
