package com.example.designPattern.adapter;
public class Client {
	public static void main(String[] args) {
		WallSocket WS = new WallSocketImpl();
		System.out.println(WS.getVolt());
		
		MobileAdapter mobileAdapter = new MobileAdapterImpl(WS);
		System.out.println(mobileAdapter.getVolt());
	}
}
