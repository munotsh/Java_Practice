package com.example.designPattern.mediatorPattern;

import java.util.HashMap;
import java.util.Map;

public class MediatorImpl implements Mediator {

	private final String CONPONANT_A = "ComponantA";
	private final String CONPONANT_B = "ComponantB";
	Map<String, Componant> map = new HashMap<>();

	@Override
	public void notifyMediator(Componant sender, String message) {
		if (CONPONANT_A.equals(sender.getName())) {
			reactOnA(message);
		} else if (CONPONANT_B.equals(sender.getName())) {
			reactOnB(message);
		}
	}

	@Override
	public void register(Componant componant) {
		this.map.put(componant.getName(), componant);
	}

	public void reactOnA(String message) {
		System.out.println("Mediator is in action: ");
		this.map.get(CONPONANT_B).receive(message);
	}

	public void reactOnB(String message) {
		System.out.println("Mediator is in action: ");
		this.map.get(CONPONANT_A).receive(message);
	}
}
