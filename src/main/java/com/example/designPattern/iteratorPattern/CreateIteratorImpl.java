package com.example.designPattern.iteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class CreateIteratorImpl implements CreateIterator {
	List<String> list;
	public CreateIteratorImpl() {
		list = new ArrayList<String>();
	}
	@Override
	public Iterator createIterator() {
		return new IteratorImpl(this);
	}
	@Override
	public void Add(String item) {
		list.add(item);
	}
	@Override
	public int size() {
		return this.list.size();
	}
	@Override
	public String getItemAtIndex(int index) {
		return this.list.get(index);
	}
}
