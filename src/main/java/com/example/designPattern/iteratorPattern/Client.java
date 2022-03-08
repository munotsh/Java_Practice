package com.example.designPattern.iteratorPattern;

public class Client {
	public static void main(String[] args) {
		CreateIterator createIterator = new CreateIteratorImpl();
		createIterator.Add("Shailesh");
		createIterator.Add("Neha");
		createIterator.Add("Vaibhav");
		createIterator.Add("Gaurav");

		Iterator iterator = createIterator.createIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
