package com.example.designPattern.bridge;

public class Client {
	public static void main(String[] args) {
		Shape cercle1 = new Cercle(new Blue());
		cercle1.draw();
		System.out.println();
		Shape cercle2 = new Cercle(new Red());
		cercle2.draw();

		System.out.println();
		Shape square1 = new Square(new Blue());
		square1.draw();
		System.out.println();
		Shape square2 = new Square(new Red());
		square2.draw();
	}
}
