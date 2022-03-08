package com.example.designPattern.strategyPattern;

public class TeamLead implements Role {
	@Override
	public String responsibilities() {
		return "lead the team as well"
				+ " as solve the issue in team";
	}
	@Override
	public String description() {
		return this.getClass().getSimpleName();
	}
}
