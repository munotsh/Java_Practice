package com.example.designPattern.abstractFactory;

public class LapTopFactory extends AbstractFactoryForDevice{

	@Override
	public Device getGadget(String device) {
		if(device.equals("HP"))
			return new Hp();
		else if(device.equals("Dell"))
			return new Dell();
		return null;
	}
}
