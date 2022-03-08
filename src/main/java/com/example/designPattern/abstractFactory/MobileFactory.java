package com.example.designPattern.abstractFactory;

public class MobileFactory extends AbstractFactoryForDevice{
	@Override
	public Device getGadget(String device) {
		if(device.equals("OnePlus"))
			return new OnePlus();
		else if(device.equals("Apple"))
			return new Apple();
		return null;
	}
}
