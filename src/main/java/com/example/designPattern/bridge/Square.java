package com.example.designPattern.bridge;

public class Square extends Shape {
	public Square(Color color) {
		super(color);
	}
	@Override
	public void draw() {
		System.out.print("Square is ");
		color.paintIt();
	}
}
