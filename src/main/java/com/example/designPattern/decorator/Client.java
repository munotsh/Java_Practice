package com.example.designPattern.decorator;

public class Client {

	public static void main(String[] args) {
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.create();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.create();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.create();
		System.out.println();
		
		Dress sportyAndFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyAndFancyDress.create();
		System.out.println();

	}

}
