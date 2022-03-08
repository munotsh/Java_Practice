package com.example.designPattern.mediatorPattern;

public class ComponantB extends Componant {
	public ComponantB(Mediator mediator) {
		super("ComponantB", mediator);
	}

	@Override
	public void send() {
		String message = "Whats up";
		System.out.println("b is sending: " + message);
		this.mediator.notifyMediator(this, message);
	}

	@Override
	public void receive(String message) {
		System.out.println("Componant B received : " + message);
	}
}
