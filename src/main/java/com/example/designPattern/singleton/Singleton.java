package com.example.designPattern.singleton;

public class Singleton {
	
	static Singleton singleton;
	
	private Singleton() {
		
	}
	
	public static Singleton getSingleton() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

}
