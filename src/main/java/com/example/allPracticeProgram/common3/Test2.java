package com.example.allPracticeProgram.common3;

public class Test2 {

	public static void main(String[] args) {
		
		System.out.println(log(5,3));
		
//		int n = 4;
//		int b = 2;
//		double c=0;	    	
//		while(n>1)
//		{
//		n=n/b;	
//		c++;	
//		}   
//		c=c+n;
//		    System.out.println("log value of n approximately equals to: "+(c-1));
//		    
		}

	private static int log(int n, int b) {
		int multi =1 ;
		int count =0;
		 while(n>1){
			n = n / b;
			count++;
		}
//		System.out.println(Math.log(multi));
		return count;
	}

	
	
}
