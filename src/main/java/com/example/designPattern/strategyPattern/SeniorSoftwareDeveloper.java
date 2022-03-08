package com.example.designPattern.strategyPattern;

public class SeniorSoftwareDeveloper implements Role {
	@Override
	public String responsibilities() {
		return "write the code as well"
			+ " as mentor new software developer";
	}
	@Override
	public String description() {
		return this.getClass().getSimpleName();
	}
}
