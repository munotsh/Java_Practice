package com.example.designPattern.strategyPattern;

public class SoftwareDeveloper implements Role {
	@Override
	public String responsibilities() {
		return "writes Code";
	}
	@Override
	public String description() {
		return this.getClass().getSimpleName();
	}
}
