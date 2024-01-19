package com.example.allPracticeProgram.MorganStanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheLargestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLargestString("zzzazz", 2));
	}

	static String getLargestString(String s, int k) {
		char[] ch = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();

		for (Character c : ch)
			map.put(c, map.getOrDefault(c, 0) + 1);

		Arrays.sort(ch);
		char prev = '0';

		int left = ch.length - 1, right = ch.length - 1, count = 0;
		for (; right >= 0; right--) {
			if (ch[left] == ch[right] && map.get(ch[right]) != 0 && ch[right] != prev) {
				while (count < k && map.get(ch[right]) != 0) {
					list.add(ch[right]);
					map.put(ch[right], map.get(ch[right]) - 1);
					count++;
				}
			} else if (count == k && map.get(ch[right]) != 0) {
				list.add(ch[right]);
				map.put(ch[right], map.get(ch[right]) - 1);
				right = left + 1;
				count = 0;
				prev = list.get(list.size() - 1);

			} else {
				left--;
				right = left + 1;
				count = 0;
				prev = list.get(list.size() - 1);
			}
		}

		StringBuffer sb = new StringBuffer();
		for(char s1:list) {
			sb.append(s1);
		}
		
		return sb.toString();
	}
}
