package com.example.designPattern.factory;

public class Client {
	public static void main(String[] args) {
		Mobile m = MobileFactory.getMobile("Apple");
		System.out.println(m.getDetails());
		 m = MobileFactory.getMobile("Oppo");
		System.out.println(m.getDetails());
		 m = MobileFactory.getMobile("OnePlus");
		System.out.println(m.getDetails());
	}
}

