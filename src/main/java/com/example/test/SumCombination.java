package com.example.test;

import java.util.ArrayList;
import java.util.List;

public class SumCombination {

	public static void main(String[] args) {

		int targetSum = 5;
		
		List<Integer> output = new ArrayList<Integer>();
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		printCombi(targetSum,0,1,output);
		
	}

	private static void printCombi(int targetSum, int sum, int start, List<Integer> output) {

		if(targetSum == sum) {
			output.forEach(System.out::print);
//			output = new ArrayList<Integer>();
			System.out.println();
		}
		
		for(int i=start;i<targetSum;i++) {
			int tempSum = sum + i;
			if(tempSum<=targetSum) {
				output.add(i);
				printCombi(targetSum, tempSum, i, output);
			}
			else
				return;
						
		}
		
	}


	/* 11111 
	   112
	   */

}
