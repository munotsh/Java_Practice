package com.example.designPattern.builderPattern1;

public class Vehical {
	int wheels;
	String name;
	String airbag;
	private Vehical(VehicalBuilder vehicalBuilder) {
		this.wheels = vehicalBuilder.wheels;
		this.name = vehicalBuilder.name;
		this.airbag = vehicalBuilder.airbag;
	}
	
	public static class VehicalBuilder{
		int wheels;
		String name;
		String airbag;
		
		public VehicalBuilder(int wheels,String name) {
			this.wheels = wheels;
			this.name = name;
		}
		
		public VehicalBuilder setAirbag(String airbag) {
			this.airbag = airbag;
			return this;
		}		
		
		public Vehical build() {
			return new Vehical(this);
		}
	}
}
