package com.example.allPracticeProgram.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumBookCopies {

	public static void main(String[] args) {
//		int[] portalUpdate = { 6, 6, 2, -6, -2, -6 };
		int[] portalUpdate = { 1,2,-1,2 };
		findMaximumBookCopies(portalUpdate);
	}

	private static void findMaximumBookCopies(int[] portalUpdate) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] ans = new int[portalUpdate.length];
		int max = 0;
		for (int i = 0; i < portalUpdate.length; i++) {
			int bookId = Math.abs(portalUpdate[i]);
			if (map.containsKey(portalUpdate[i])) {
				map.put(bookId, map.get(portalUpdate[i]) + 1);
				max = Math.max(max, map.get(portalUpdate[i]));
			} else {
				if (portalUpdate[i] > 0) {
					map.put(bookId, 1);
					max = Math.max(max, map.get(portalUpdate[i]));
				} else {
					map.put(bookId, map.get(bookId) - 1);
					max = map.entrySet().stream().map(e -> e.getValue()).max(Integer::compareTo).get();
				}

			}
			ans[i] = Math.max(max, map.get(bookId));
		}

		Arrays.stream(ans).forEach(System.out::print);
	}

}
