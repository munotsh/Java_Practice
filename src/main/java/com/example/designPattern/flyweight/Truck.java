package com.example.designPattern.flyweight;

public class Truck implements Vehical{

	private final String speed;
	private String color;
	
	public Truck(){
		this.speed = "120 km/hr";
	}
	
	@Override
	public void asignColor(String color) {
		this.color = color;
		
	}
	
	@Override
	public void startEngine() {

		System.out.println(color+" colored truck with max speed is "+speed);
	}
}
