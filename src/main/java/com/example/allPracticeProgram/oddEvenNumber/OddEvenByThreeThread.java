package com.example.allPracticeProgram.oddEvenNumber;

public class OddEvenByThreeThread {
	static boolean t1 = true;
	static boolean t2 = false;
	static boolean t3 = false;
	static int i = 1;
	public static void main(String[] args) {
	Runnable one = () -> {
		for (; i <= 10;) {
			if (t1) {
System.out.println(Thread.currentThread().getName()+" = "+i);
				i++;
				t1= false;
				t2 = true;
				t3 = false;
			}
		}
	};
	Runnable two = () -> {
		for (; i <= 10;) {
			if (t2) {
System.out.println(Thread.currentThread().getName()+" = "+i);
				i++;
				t1= false;
				t2 = false;
				t3 = true;
			}
		}
	};
	Runnable three = () -> {
		for (; i <= 10;) {
			if (t3) {
System.out.println(Thread.currentThread().getName()+" = "+i);
				i++;
				t1= true;
				t2 = false;
				t3 = false;
			}
		}
	};
	new Thread(one).start();
	new Thread(two).start();
	new Thread(three).start();
	}
}
