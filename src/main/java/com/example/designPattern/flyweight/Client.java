package com.example.designPattern.flyweight;

public class Client {

	public static void main(String[] args) throws Exception {
		Vehical cycle1 = FliyweightFactory.getInstence("Cycle");
		cycle1.asignColor("blue");
		cycle1.startEngine();
		
		Vehical truck1 = FliyweightFactory.getInstence("Truck");
		truck1.asignColor("blue");
		truck1.startEngine();
		
		Vehical cycle2 = FliyweightFactory.getInstence("Cycle");
		cycle2.asignColor("red");
		cycle2.startEngine();
		
		Vehical truck2 = FliyweightFactory.getInstence("Truck");
		truck2.asignColor("red");
		truck2.startEngine();
	}

}
