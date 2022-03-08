package com.example.designPattern.prototype;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {

		BookShop b1 = new BookShop();
		b1.setShopName("b1");
		b1.loadData();
		System.out.println(b1);
		System.out.println(b1.hashCode());
		
		BookShop b2 = (BookShop) b1.clone();
		b2.setShopName("b2");
		System.out.println(b2);
		System.out.println(b2.hashCode());
	}
}
