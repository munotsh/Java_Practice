package com.example.allPracticeProgram.morgan_stanley;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Moves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		arr1.add(123);
		arr1.add(543);
		arr2.add(321);
		arr2.add(279);
		int moves =0;
		for(int i=0;i<arr1.size();i++) {
			int r1 = arr1.get(i);
			int r2 = arr2.get(i);
			while(r1>0 && r2 >0) {
				int lastR1 = r1%10;
				int lastR2 = r2%10;
				System.out.println(" lastR1 = "+lastR1+" lastR2 = "+lastR2);
				if(lastR1 > lastR2) {
					moves = moves +(lastR1 - lastR2);
				}
				else {
					moves = moves +(lastR2 - lastR1);
				}
				r1 = r1/10;
				r2 = r2/10;
			}
		}
		
		
		System.out.println(moves);
	}

}
