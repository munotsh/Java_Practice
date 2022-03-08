package com.example.designPattern.singleton;

public class Test {

	public static void main(String[] args) {
		Singleton singletonOne = Singleton.getSingleton();
		Singleton singletonTwo = Singleton.getSingleton();
		System.out.println(singletonOne == singletonTwo);
	}

}
