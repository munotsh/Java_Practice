package com.example.allPracticeProgram.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 1, 3, 2 };
//		int[] arr = { 3, 1, 2 };
//		int[] arr = { 1,2};
		System.out.println(find(arr));
	}

	private static long find(int[] arr) {
		int k = 2;
		int count = 0;
		while (k <= arr.length) {
			Deque<Integer> deque = new LinkedList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				deque.addLast(arr[i]);
				if (deque.size() > k - 1) {
					List<Integer> l = new ArrayList<Integer>(deque);
					Collections.sort(l);
					count += findDeff(l, k);
					System.out.println(l);
					deque.removeFirst();
				}
				else {
					
				}
			}
			k++;
		}
		return count;
	}

	private static int findDeff(List<Integer> l, int k) {
		int count = 0;
		for (int i = 1; i < l.size(); i++) {
			if ((l.get(i) - l.get(i - 1)) > 1) {
				count++;
			}
		}
		return count;
	}

}
