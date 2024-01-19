package com.example.allPracticeProgram.common;

import java.sql.Date;

public final class Employee {

	private final int id;
	private final String name;
	private final int did;
	private final int salary;
	public Employee(int id, String name, int did, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.did = did;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getDid() {
		return did;
	}
	public int getSalary() {
		return salary;
	}
	
	
	
	
}
