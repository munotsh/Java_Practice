package com.example.designPattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {

	String shopName;
	List<Book> books = new ArrayList<>();

	public BookShop() {

	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void loadData() {
		for (int i = 1; i <= 10; i++) {
			this.getBooks().add(new Book(i, "book_" + i));
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return shopName+ " = "+books;
	}
}
