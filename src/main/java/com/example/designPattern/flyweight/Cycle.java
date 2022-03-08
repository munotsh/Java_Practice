package com.example.designPattern.flyweight;

public class Cycle implements Vehical{

	private final String speed; 
	private String color; 
	public Cycle() {
	this.speed = "50 km/hr";
	}
	
	@Override
	public void asignColor(String color) {
		this.color = color;
	}

	@Override
	public void startEngine() {
		System.out.println(this.color+" colored cycle with max speed "+this.speed);		
	}

}
