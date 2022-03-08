package com.example.designPattern.builderPattern1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehical v1 = new Vehical.VehicalBuilder(2, "abc").setAirbag("4").build();
		Vehical v2 = new Vehical.VehicalBuilder(2, "abc").build();
	}

}


