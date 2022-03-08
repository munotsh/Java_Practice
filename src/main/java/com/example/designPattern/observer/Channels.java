package com.example.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channels {
	
	public List<Subscribers> subList = new ArrayList<>();
	String title;
	
	public void addSubscription(Subscribers sub) {
		subList.add(sub);
	}
	
	public void removeSubscription(Subscribers sub) {
		subList.remove(sub);
	}
	
	public void notifySubcribers() {
		for(Subscribers bs:subList) {
			bs.update(this.title);
		}
	}
	
	public void upload(String vedioName) {
		this.title = vedioName;
		notifySubcribers();
	}

}
