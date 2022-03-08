package com.example.designPattern.abstractFactory;

public class Clent {
	public static void main(String[] args) {
		Dell d = (Dell) AbstractFactory.getFactory("LapTop").getGadget("Dell");
		System.out.println(d.getDetails());
	}
}
