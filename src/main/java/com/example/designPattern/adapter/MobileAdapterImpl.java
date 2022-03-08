package com.example.designPattern.adapter;

public class MobileAdapterImpl implements MobileAdapter {
	WallSocket wallSocket;
	public MobileAdapterImpl(WallSocket wallSocket) {
		this.wallSocket = wallSocket;
	}
	@Override
	public Volt getVolt() {
		Volt volt240 = wallSocket.getVolt();
		int volt3 = volt240.getVolt()/80; 
		return new Volt(volt3);
	}
}
