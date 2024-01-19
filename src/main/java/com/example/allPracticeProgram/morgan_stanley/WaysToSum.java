package com.example.allPracticeProgram.morgan_stanley;

import java.math.BigInteger;

public class WaysToSum {

	public static int ways(int total, int k) {
		long M = 1000000007;
	    int[][] t = new int[k + 1][total + 1];
	    for (int i = 1; i <= k; i++) {
	        for (int j = 1; j <= total; j++) {
	            if (j < i)
	                t[i][j] = (int) (t[i - 1][j]%M);
	            else if (i == j)
	                t[i][j] = (int) (1 + (t[i - 1][j]%M));
	            else
	                t[i][j] = (int) ((t[i - 1][j]%M) + (t[i][j - i]%M));

	        }
	    }
	    
	  //  long l =(t[k][total]) ;
	  //  BigInteger b = new BigInteger(String.valueOf(l)); 
	 //   System.out.println(b.mod(BigInteger.TEN.pow(9).add(BigInteger.valueOf(7))));
	   return (int) (t[k][total]%M);
//	    return (int) ((int)l % M);
	   

	}
	public static void main (String args[]) {
		System.out.println(ways(842,91));
		//System.out.println(ways(8,2));
	}
	}


