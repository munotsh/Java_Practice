package com.example.allPracticeProgram.MorganStanley;

import java.util.stream.Stream;

public class Test12 extends Thread {
	private static int x;
	public synchronized void doThings() {
		int current=x;
		current++;
		x=current;
		System.out.println(x);
	}
	public void run() {
		doThings();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Stream words= Stream.of("one","two","three");
	//	int len= words.mapToInt(String::length).reduce(0,(len1,len2)->len1+len2);
	//	System.out.println(len);
		Test12 t= new Test12();
		t.start();

	}

}
