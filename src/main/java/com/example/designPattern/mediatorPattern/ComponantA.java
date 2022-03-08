package com.example.designPattern.mediatorPattern;

public class ComponantA extends Componant {
	public ComponantA(Mediator mediator) {
		super("ComponantA", mediator);
	}

	@Override
	public void send() {
		String message = "I am good";
		System.out.println("A is sending: " + message);
		this.mediator.notifyMediator(this, message);
	}

	@Override
	public void receive(String message) {
		System.out.println("Componant A received : " + message);
	}
}
