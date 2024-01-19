package com.example.allPracticeProgram.customeSemaphore;

public class Test {
	static int count = 1;
	
	static boolean flag = true;
	public static void main(String[] args) {
		
		Runnable odd = new Runnable() {
			@Override
			public void run() {
				for(int i=1;i<=1000;) {
					if(flag) {
						System.out.println(Thread.currentThread().getName()+" "+i);
						i=i+2;
						flag = false;
					}	
				}
			}
		};
		
		Runnable even = new Runnable() {
			@Override
			public void run() {
				for(int i=2;i<=1000;) {
					if(!flag) {
						System.out.println(Thread.currentThread().getName()+" "+i);
						i=i+2;
						flag = true;
					}	
				}
			}
		};
		new Thread(odd).start();
		new Thread(even).start();
	}

	
}
