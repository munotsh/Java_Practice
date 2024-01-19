package com.example.allPracticeProgram.morgan_stanley;

public class WaysToSumOld {
	static int count=0;

	public static void main(String[] args) {
	int total=842;
	//842  91  143119619
	
	int k=91;
//	System.out.println(ways(total,k));
//	 partition(total,k);
//     System.out.println("Count: "+count);
	//System.out.println(numberOfWaysForSum(total,k));
     System.out.println(recFun(k, total, 0));	

	}
	

	
	public static int recFun(int k, int n,int sum) {
		if(sum == n) 
			return 1;
		else if(sum > n)
			return 0;
		int total = 0;
		for (int i = 1; i <= k; i++) {
			total += recFun(k, n, sum+i+1);
		}
		return total;
		
	}
	
	
	
//	ll recFun(ll k, ll n, ll sum = 0) {
//		  if (sum == n) {
//		    return 1;
//		  } else if (sum > n) return 0;
//		 
//		 
//		  ll total = 0;
//		 
//		  FO(i, k) {
//		    total += recFun(k, n, sum+i+1);
//		  }
//		 
//		  return total;
//		}
	
	
	
	
//	public static int ways(int total, int k) {
//	    int[][] t = new int[k + 1][total + 1];
//	    for (int i = 1; i <= k; i++) {
//	        for (int j = 1; j <= total; j++) {
//	            if (j < i)
//	                t[i][j] = t[i - 1][j];
//	            else if (i == j)
//	                t[i][j] = 1 + t[i - 1][j];
//	            else
//	                t[i][j] = t[i - 1][j] + t[i][j - i];
//
//	        }
//	    }
//	    return t[k][total];
//
//	}
	
//	public static void partition(int n, int max) {
//        if (n == 0) {
//            count++;
//            return;
//        }
//        for (int i = Math.min(max, n); i >= 1; i--) {   
//        	System.out.println("shailesh");
//            partition(n - i, i);
//        }
//    }
	
//	private static int numberOfWaysForSum(int n, int k) {
//		  int[][] a = new int[k + 1][n + 1];
//		  for (int i = 1; i <= n; i++) {
//		    a[1][i] = 1;
//
//		  }
//		  for (int i = 1; i <= k; i++) {
//		    a[i][0] = 1;
//		  }
//		  for (int i = 2; i <= k; i++) {
//		    for (int j = 1; j <= n; j++) {
//		      if (j >= i) {
//		        a[i][j] = a[i][j - i] + a[i - 1][j];
//
//		      } else {
//		        a[i][j] = a[i - 1][j];
//		      }
//
//		    }
//		  }
//		  return a[k][n];
//		}

}
