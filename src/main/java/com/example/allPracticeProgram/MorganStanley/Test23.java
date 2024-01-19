package com.example.allPracticeProgram.MorganStanley;

import java.util.Arrays;
import java.util.Objects;

public class Test23 implements Runnable {
	public void run() {
		System.out.println("run");
		throw new RuntimeException("Problem");
	}
	public static void main(String[] args) {
		Thread t= new Thread(new Test23());
		t.start();
		System.out.println("End of method");
		
				// TODO Auto-generated method stub
//		Object[] myobjects= {
//				new Integer(12),
//				new String("foo"),
//				new Integer(5),
//				new Boolean(true)
//		};
//		Arrays.sort(myobjects);
//		for (int i=0;i<myobjects.length;i++) {
//			System.out.print(myobjects[i].toString());
//			System.out.print(" ");
		
		}
	}


