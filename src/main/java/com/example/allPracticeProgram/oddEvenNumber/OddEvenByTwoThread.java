package com.example.allPracticeProgram.oddEvenNumber;

public class OddEvenByTwoThread {

	static boolean flag = true;
	public static void main(String[] args) {
		Runnable odd = () -> {
			for (int i = 1; i <= 10;) {
				if (flag) {
					System.out.println(Thread.currentThread().getName()+" = "+i);
					i = i + 2;
					flag = false;

				}
			}
		};
		Runnable even = () -> {
			for (int i = 2; i <= 10;) {
				if (!flag) {
					System.out.println(Thread.currentThread().getName()+" = "+i);
					i = i + 2;
					flag = true;
				}
			}
		};
		new Thread(odd).start();
		new Thread(even).start();
	}
}
