package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pp = { 2, 1, 3, 4, 5 };
		int[] bp = { 3, 6, 1, 3, 4 };
		int maxp = 25;
		System.out.println(findMaxCS(pp, bp, maxp));

	}

	private static int findMaxCS(int[] pp, int[] bp, int maxp) {
		int k = 2;
		int max =0;
		int maxk = k;
		while (k < pp.length) {
			for (int i = 0; i < (pp.length - k) + 1; i++) {
				List<Integer> maxList = new ArrayList<Integer>();
				int sum = 0;
				for (int j = i; j < i + k; j++) {
//					System.out.println(pp[j]);
					maxList.add(bp[j]);
					sum += pp[j];
				}
//				System.out.println("Max = " + Collections.max(maxList));
//				System.out.println("sum = " + sum);
				int net = Collections.max(maxList) + (sum * k);
//				System.out.println("net = " + net);
//				System.out.println();
				if(max<net && net<maxp) {
					maxk = k;
					max = net;
				}
				
			}
			k++;
		}
		System.out.println("MAX = " + max);
		System.out.println("MAXk = " + maxk);
		
		return maxk;
	}

}
