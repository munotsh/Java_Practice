package com.example.designPattern.mediatorPattern;

public interface Mediator {
	public void notifyMediator(Componant Componant, String message);
	public void register(Componant Componant);
}
