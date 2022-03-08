package com.example.designPattern.strategyPattern;

public class Employee {
	String name;
	Role role;
	public Employee(String name,Role role) {
	this.name = name;
	this.role = role;
	}
	public void promote(Role role) {
		this.role = role;		
	}
	public void doWork() {
System.out.println(this.name+" is a "
			+this.role.description()
			+" and responsible to "+
			this.role.responsibilities());
	}
}
