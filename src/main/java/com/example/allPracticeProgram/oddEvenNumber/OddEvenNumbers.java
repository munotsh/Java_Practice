package com.example.allPracticeProgram.oddEvenNumber;

public class OddEvenNumbers {
	static boolean flag = true;
	int counter = 1;
	static int N;
	public void printOddNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" = "+counter + " ");
				counter++;
				notify();
			}
		}
	}

	public void printEvenNumber() {
		synchronized (this) {
			while (counter < N) {
				while (counter % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" = "+counter + " ");
				counter++;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		N = 10;
		OddEvenNumbers mt = new OddEvenNumbers();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mt.printEvenNumber();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt.printOddNumber();
			}
		});
		t1.start();
		t2.start();
	}
}
