package com.example.designPattern.abstractFactory;

public class AbstractFactory {
	public static AbstractFactoryForDevice getFactory(String factoryType) {
		if(factoryType.equals("Mobile")) {
			return new MobileFactory();
		}
		else if(factoryType.equals("LapTop")) {
			return new LapTopFactory();	
		}
		return null;
	}
}
