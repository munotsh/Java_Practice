package com.example.allPracticeProgram.nexer;

import java.util.Scanner;

public class PerSecretCode {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();

		input.toUpperCase();
		String per = "PER";
		int days = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != per.charAt(i % per.length()))
				days++;
		}
		System.out.println(days);
	}

}
