package com.example.allPracticeProgram.amazon;

public class MatchesToWin {
	
	public static long fact(int k) {
	int num = 10;
    long factorial = 1;
    for(int i = 1; i <= k; ++i)
    {
        // factorial = factorial * i;
        factorial *= i;
    }
    return factorial;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int M=4, N=1;
	//	ans=(M+N-1)!/((M-1)! * (N)!);
		System.out.println(fact(M+N-1)/(fact(M-1)*fact(N)));

	}

}
