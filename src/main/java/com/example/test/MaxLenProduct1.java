package com.example.test;

public class MaxLenProduct1 {
	static int max(int a[]) {
		int c = 0;
		int fnegindex = -1;// for the first negative index
		int lnegindex = -1;// for the last negative index
		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1) {
				if (fnegindex == -1) {
					fnegindex = i;
				}
				lnegindex = i;
				c++;
			}
		}
		if (c % 2 == 0)
			return a.length;
		else {
			return Math.max(a.length - fnegindex - 1, lnegindex);
		}

	}

	public static void main(String[] args) {
		int[] a = { -1, -1, 1, 1, -1 };
		// int [] a= {-1,-1,-1,-1,-1,1};
		// int[] a= {1,1,1,1,1,-1,1,1};
		System.out.println(max(a));
	}
}
