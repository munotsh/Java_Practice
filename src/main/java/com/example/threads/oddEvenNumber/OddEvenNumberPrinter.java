package com.example.threads.oddEvenNumber;

public class OddEvenNumberPrinter {
	static boolean flag = true;

	public static void main(String[] args) {
		Runnable odd = () -> {
			for (int i = 1; i <= 10;) {
				if (flag) {
					System.out.println(Thread.currentThread().getName()+" = "+i);
					i += 2;
					flag = !flag;
				}
			}
		};
		
		Runnable even = () ->{
			for(int i=2;i<= 10;) {
				if(!flag) {
					System.out.println(Thread.currentThread().getName()+" = "+i);
					i+=2;
					flag = !flag;
				}
			}
		};
		
		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);
		t1.start();
		t2.start();
	}

}

