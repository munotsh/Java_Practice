package com.example.allPracticeProgram.cisco;

import java.util.ArrayList;
import java.util.List;

public class CiscoTest {

	public static void main(String[] args) {
		List<Integer> w = new ArrayList<Integer>();
		w.add(1);
		w.add(3);
		w.add(5);
		int cap = 7;
		boolean[] dp = new boolean[cap + 1];
		dp[0] = true;
		int maxW = 0;
		for (int i = 0; i < w.size(); ++i) {
			for (int j = cap - w.get(i); j >= 0; --j) {
				if (dp[j]) {
					dp[j + w.get(i)] = true;
					maxW = Math.max(maxW, j + w.get(i));
				}
			}
		}

		System.out.println(maxW);
	}

}
