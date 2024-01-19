package com.example.allPracticeProgram.common;

public class Test8 {

	public static void main(String[] args) {
		int x = 2, y = 10, z = 15;
		int count = 0;
		for (int i = 10; i <= 15; i++) {
			boolean flag = false;
			int n = i;
			int mult = x * i;
			while (n > 0) {
				int s = n % 10;
				if (String.valueOf(mult).contains(s + "")) {
					flag = true;
					break;
				}
				n = n / 10;
			}

			if (!flag) {
				count++;
//		System.out.println(mult);
			}

		}
		System.out.println(count);
	}

}
