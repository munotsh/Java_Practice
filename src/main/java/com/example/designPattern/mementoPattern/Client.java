package com.example.designPattern.mementoPattern;

public class Client {
	public static void main(String[] args) {
		String s1 = "Shailesh";
		String s2 = "Neha";

		Orignator orignator = new Orignator();
		CareTaker careTaker = new CareTaker();

		orignator.setArticle(s1);
		careTaker.addMemento(orignator.save());
		print(orignator);

		orignator.setArticle(s2);
		careTaker.addMemento(orignator.save());
		print(orignator);

		orignator.restore(careTaker.undo());
		print(orignator);

		orignator.restore(careTaker.redo());
		print(orignator);
	}
	public static void print(Orignator orignator) {
		System.out.println("Current State " + orignator.getArticle());
	}
}
