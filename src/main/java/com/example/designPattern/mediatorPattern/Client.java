package com.example.designPattern.mediatorPattern;

public class Client {
	public static void main(String[] args) {
		Mediator mediator = new MediatorImpl();
		Componant componantA = new ComponantA(mediator);
		Componant componantB = new ComponantB(mediator);
		mediator.register(componantA);
		mediator.register(componantB);
		componantB.send();
		componantA.send();
	}
}
