package com.example.designPattern.bridge;

public class Cercle extends Shape {
	public Cercle(Color color) {
		super(color);
	}
	@Override
	public void draw() {
		System.out.print("Cercle is ");
		color.paintIt();
	}
}
