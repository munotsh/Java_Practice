package com.example.allPracticeProgram.common;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test7 {

	public static void main(String[] args) {

		String s = "abccca";
		int k = 4;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				int count = 1;
				String sub = s.substring(i, j);
				char[] ch = sub.toCharArray();
//					System.out.println(ch);
				for (int z = 0; z < ch.length - 1; z++) {
					if (ch[z] != ch[z + 1]) {
						count++;
					}
				}
				if (count == k) {
					System.out.println(sub);
				}
			}
		}
	}

}
