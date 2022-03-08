package com.example.designPattern.decorator;

public class CasualDress extends DecoratorClass{

	public CasualDress(Dress dress) {
		super(dress);
	}

	@Override
	public void create() {
		super.create();
		System.out.println("Casual Dress");
		
	}

}
