package com.example.breakSingleton;

public class Singlton {
	public static Singlton singlton = null;
	private Singlton()
	{
		
	}
	
	public static Singlton getSingleton() {
		if(null == singlton) {
			singlton = new Singlton();
		}
		return singlton;
	}

}
