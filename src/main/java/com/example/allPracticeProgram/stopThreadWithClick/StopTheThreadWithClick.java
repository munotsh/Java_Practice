package com.example.allPracticeProgram.stopThreadWithClick;

import java.util.Scanner;

public class StopTheThreadWithClick implements Runnable {

	public static void main(String[] args) {
		StopTheThreadWithClick click = new StopTheThreadWithClick();
		Thread thread = new Thread(click);
		thread.start();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		click.stopTheThread();

	}

	public static boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println("hello");
		}
	}

	public void stopTheThread() {
		flag = false;
	}

}
