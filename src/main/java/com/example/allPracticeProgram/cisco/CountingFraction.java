package com.example.allPracticeProgram.cisco;

public class CountingFraction {
	public static void main(String[] args) {
	    int N = 1000000;
	    int[] phi = new int[N + 1];
	    for(int i = 0; i < phi.length; i++) {
	        phi[i] = i;
	    }
	    
	    for(int i = 2; i <= N; i++) {
	        if(phi[i] == i) {
	            for(int k = 1; k * i <= N; k++) {
	                phi[k * i] -= phi[k * i] / i;
	            }
	        }
	    }
	    
	    long[] sums = new long[phi.length];
	    for(int i = 2; i <= N; i++) {
	        sums[i] = sums[i - 1] + phi[i];
	    }
	    
	    
	        int T = 8;
	            System.out.println(sums[T]);
	    }
}
