package com.example.designPattern.strategyPattern;

public class Manager implements Role {
	@Override
	public String responsibilities() {
		return "to manage the project "
				+ "as well as client";
	}
	@Override
	public String description() {
		return this.getClass().getSimpleName();
	}
}
