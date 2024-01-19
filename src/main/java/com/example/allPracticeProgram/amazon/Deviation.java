package com.example.allPracticeProgram.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Deviation {

//	private static void getMaximumFrequencyDeviation(String s) {
//		HashMap<Character, Integer> map = new HashMap<>();
//		int dev = 0;
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i + 1; j <= s.length(); j++) {
//				String sub = s.substring(i, j);
//				for (int k = 0; k < sub.length(); k++) {
//					char c = sub.charAt(k);
//					Integer val = map.get(c);
//					if (val != null) {
//						map.put(c, new Integer(val + 1));
//					} else {
//						map.put(c, 1);
//					}
//				}
//			}
//			Integer[] a = map.values().toArray(new Integer[0]);
//			int max = a[0];
//			int min = a[0];
//			for (int j = 1; j < a.length; j++) {
//				if (a[j] > max) {
//					max = a[j];
//				}
//				if (a[j] < min) {
//					min = a[j];
//				}
//			}
//			if (dev < max - min) {
//				dev = max - min;
//			}
//			map.clear();
//		}
//		System.out.println(dev);
//	}

	public static void main(String[] args) {
		String str = "aabb";
//		String str = "bbacccabab";
//		String str = "aaaaa";
		int len = str.length();
		Set<String> s = new HashSet<String>();
		int max = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {

				String input = str.substring(i, j);
				if (!s.contains(input)) {
					s.add(input);
					int m = findMaxDeviation(input);
					System.out.println(input + " = " + m);
					max = Math.max(max, m);
					
//					System.out.println();
				}
			}
		}
		System.out.println("max = " + max);

	}

	public static int findMaxDeviation(String a) {
		int left = 0, right = a.length() - 1;
		int maxDeviation = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (left < right) {
			int min = 0;
			int max = 0;
			for (int i = left; i <= right; i++) {
				map.put(Character.valueOf(a.charAt(i)), map.getOrDefault(Character.valueOf(a.charAt(i)), 0) + 1);
				min = map.get(Character.valueOf(a.charAt(i)));
				max = map.get(Character.valueOf(a.charAt(i)));
			}
			for (Map.Entry<Character, Integer> e : map.entrySet()) {
				min = Math.min(min, e.getValue());
				max = Math.max(max, e.getValue());
			}
			maxDeviation = Math.max(maxDeviation, max - min);
			Character leftChar = Character.valueOf(a.charAt(left));
			Character rightChar = Character.valueOf(a.charAt(right));
			if (!map.containsKey(leftChar) || (map.get(leftChar) >= min && map.get(leftChar) < max))
				left++;
			else if (!map.containsKey(rightChar) || (map.get(rightChar) >= min && map.get(rightChar) < max))
				right--;
			else
				break;
			map.clear();
		}
		return maxDeviation;
	}

}
