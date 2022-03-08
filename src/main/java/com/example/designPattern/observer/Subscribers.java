package com.example.designPattern.observer;

public class Subscribers {

	String subName;
	
	public Subscribers(String subName) {
		this.subName = subName;
	}
	
	public void update(String tital) {
		System.out.println(this.subName+" got Notification for "+tital);		
	}
}
