package com.example.designPattern.decorator;

public class SportyDress extends DecoratorClass{

	public SportyDress(Dress dress) {
		super(dress);
	}

	@Override
	public void create() {
		super.create();
		System.out.println("Sporty dress");
		
	}

}
