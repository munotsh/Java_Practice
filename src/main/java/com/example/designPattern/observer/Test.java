package com.example.designPattern.observer;

public class Test {

	public static void main(String[] args) {

		Subscribers s1 = new Subscribers("Shailesh");
		Subscribers s2 = new Subscribers("Neelam");
		Subscribers s3 = new Subscribers("Neha");
		Subscribers s4 = new Subscribers("Vaibhav");
		Subscribers s5 = new Subscribers("Gaurav");
		
		Channels c = new Channels();
		c.addSubscription(s1);
		c.addSubscription(s2);
		c.addSubscription(s3);
		c.addSubscription(s4);
		c.addSubscription(s5);
		
		c.upload("Observer design Pattern Part 1");;
		c.removeSubscription(s2);
		c.upload("Observer design Pattern Part 2");
		
	}

}
