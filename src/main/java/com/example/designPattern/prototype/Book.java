package com.example.designPattern.prototype;

public class Book {
	int id;
	String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id+" = "+name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
