package com.example.designPattern.bridge;

public class Blue implements Color{
	@Override
	public void paintIt() {
		System.out.print("painted with Blue color");
	}
}
