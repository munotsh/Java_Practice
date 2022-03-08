package com.example.designPattern.decorator;

public class FancyDress extends DecoratorClass{

	public FancyDress(Dress dress) {
		super(dress);
	}


	@Override
	public void create() {
		super.create();
		System.out.println("Fancy Dress");
		
	}

}
