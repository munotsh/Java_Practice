package com.example.designPattern.factory;

public class MobileFactory {

	public static Mobile getMobile(String mobileName) {
		if (mobileName.equals("OnePlus")) {
			return new OnePlus();
		} else if (mobileName.equals("Apple")) {
			return new Apple();
		} else if (mobileName.equals("Oppo")) {
			return new Oppo();
		}
		return null;
	}
}
