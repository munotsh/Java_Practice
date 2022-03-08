package com.example.designPattern.adapter;

public class WallSocketImpl implements WallSocket {
	@Override
	public Volt getVolt() {
		return new Volt(240);
	}
}
