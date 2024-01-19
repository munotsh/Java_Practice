package com.example.allPracticeProgram.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 8, 8, 9, 4, 4};

Arrays.sort(arr);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> l = new ArrayList<Integer>();
		for (int i : arr) {
			if (!set.add(i)) {
				l.add(i);
			} 
		}

		
		if (l.size() > 0) {
			System.out.println(l);
		} else {
			System.out.println(-1);
		}
	}

}
