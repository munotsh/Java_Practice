package com.example.allPracticeProgram.nexer;

import java.util.Scanner;

public class PerSecretCode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		s.close();
		
//		long startTime = System.nanoTime();
		input.toUpperCase();
		String per = "PER";
		int days = 0;
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) != per.charAt(i%3))
				days++;
		}
		System.out.println(days);
//		long endTime   = System.nanoTime();
//		long totalTime = endTime - startTime;
//		System.out.println(totalTime);
//		System.out.println(TimeUnit.MILLISECONDS.toMillis(totalTime));
//		System.out.println(TimeUnit.NANOSECONDS.toSeconds(totalTime));
	}

}