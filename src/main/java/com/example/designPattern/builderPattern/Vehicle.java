package com.example.designPattern.builderPattern;

public class Vehicle {
	String engin;
	int wheel;
	int airBag;
	
	private Vehicle(VehicleBuilder vehicleBuilder) {
		this.engin = vehicleBuilder.engin;
		this.wheel = vehicleBuilder.wheel;
		this.airBag = vehicleBuilder.airBag;
	}

	public String getEngin() {
		return engin;
	}

	public int getWheel() {
		return wheel;
	}

	public int getAirBag() {
		return airBag;
	}

	public static class VehicleBuilder {
		String engin;
		int wheel;
		int airBag;

		public VehicleBuilder(String engin, int wheel) {
			this.engin = engin;
			this.wheel = wheel;
		}

		public VehicleBuilder setAirBag(int airBag) {
			this.airBag = airBag;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}
	}
}
