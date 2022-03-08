package com.example.designPattern.iteratorPattern;

public interface CreateIterator {
	Iterator createIterator();
	public int size();
	public void Add(String item);
	public String getItemAtIndex(int index);
}
