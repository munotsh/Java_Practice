package com.example.designPattern.decorator;

public class DecoratorClass implements Dress{

	Dress dress;
	public DecoratorClass(Dress dress){
		this.dress = dress;
	}
	
	@Override
	public void create() {
		this.dress.create();
		
	}

}
