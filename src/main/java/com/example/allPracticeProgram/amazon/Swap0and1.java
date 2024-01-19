package com.example.allPracticeProgram.amazon;

public class Swap0and1 {

	static void swap(int s, int e, int a[]) {
		int temp = a[e];
		a[e] = a[s];
		a[s] = temp;
	}

	static int operationright(int a[]) {
		// in this operation we try to make the configuration 11000 type
		int s = 0;
		int e = 0;
		// 0 1 1 0 1 0 1 0 1
		int ans = 0;
		while (e < a.length) {
			// lets convert it to first configuration ie 11000
			while (e < a.length && a[e] == 0) {
				e++;
			}
			if (e < a.length)
				ans += e - s;
			if (e < a.length && s != e)
				swap(s, e, a);
			s++;
			e++;
		}
		return ans;
	}

	static int operationleft(int a[]) {
		int s = 0;
		int e = 0;
		// 0 1 1 0 1 0 1 0 1
		int ans = 0;
		while (e < a.length) {
			// lets convert it to first configuration ie 0000111
			while (e < a.length && a[e] == 1) {
				e++;
			}
			if (e < a.length)
				ans += e - s;
			if (e < a.length && s != e)
				swap(s, e, a);
			s++;
			e++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] a= {0,1,0,1};
		int [] a= {1,1,0,1};
		System.out.println(Math.min(operationleft(a),operationright(a)));
	}

}
