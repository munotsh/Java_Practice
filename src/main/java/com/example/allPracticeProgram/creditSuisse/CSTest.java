package com.example.allPracticeProgram.creditSuisse;

public class CSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i=1;
//		while(true) {
//			if(checkPerfectSquare(i)) {
//				System.out.println(i);
//				break;
//			}
//			i++;
//		}
		
		int i =5;
		int k = 3;
//		System.out.println(Math.abs(i/2)+1);
		System.out.println((Math.abs(i/2)+1)+k);

	}
	
	static boolean checkPerfectSquare(double x)  
    { 
	 
	double sq = Math.sqrt(x); 

	return ((sq - Math.floor(sq)) == 0); 
    } 

}
