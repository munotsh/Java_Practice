package com.example.designPattern.builderPattern;

public class client {

	public static void main(String[] args) {
		Vehicle car = new Vehicle.VehicleBuilder("abc",4).setAirBag(4).build();
		Vehicle bike = new Vehicle.VehicleBuilder("xyz",2).build();

		
		System.out.println(car.getEngin()+" "+car.getWheel()+" "+car.getAirBag());
		System.out.println(bike.getEngin()+" "+bike.getWheel()+" "+bike.getAirBag());
	}

}

