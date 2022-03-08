package com.example.designPattern.mediatorPattern;

public abstract class Componant {
	private String name;
	protected Mediator mediator;

	public Componant(String name, Mediator mediator) {
		super();
		this.name = name;
		this.mediator = mediator;
	}

	public abstract void send();
	public abstract void receive(String message);

	public String getName() {
		return name;
	}
}
