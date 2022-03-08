package com.example.breakSingleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable{
	public static SerializableSingleton singlton = null;
	private SerializableSingleton()
	{
		
	}
	
	public static SerializableSingleton getSingleton() {
		if(null == singlton) {
			singlton = new SerializableSingleton();
		}
		return singlton;
	}

}
