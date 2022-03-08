package com.example.breakSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException {
		Singlton singlton1 = Singlton.getSingleton();
		Singlton singlton2 = Singlton.getSingleton();
		Constructor[] constructors = Singlton.class.getDeclaredConstructors();
		Singlton singlton = null;
		for (Constructor cons : constructors) {
			cons.setAccessible(true);
			singlton = (Singlton) cons.newInstance();
		}
		System.out.println(singlton2 == singlton1);
		System.out.println(singlton == singlton1);

		Color c = Color.blue;
		Constructor[] colorConst = Color.class.getConstructors();
		Color color = null;
		for (Constructor constructor : colorConst) {
			constructor.setAccessible(true);
			color = (Color) constructor.newInstance();
		}

		System.out.println(color == c);
		
		
		
		
		/////////////////using clonable///////////////
		
		SingletonClonable singletonClonable1 =  SingletonClonable.getInstence();
		SingletonClonable singletonClonable2 =  SingletonClonable.getInstence();
		System.out.println(singletonClonable1 == singletonClonable2);
		singletonClonable1 = (SingletonClonable)singletonClonable1.clone();
		System.out.println(singletonClonable1 == singletonClonable2);
		
		
		
		
	}

}
