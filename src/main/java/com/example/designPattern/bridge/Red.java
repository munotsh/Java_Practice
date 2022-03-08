package com.example.designPattern.bridge;

public class Red implements Color{
	@Override
	public void paintIt() {
		System.out.print("painted with Red color");
	}
}
