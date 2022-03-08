package com.example.designPattern.iteratorPattern;

public class IteratorImpl implements Iterator {
	private CreateIteratorImpl createIteratorImpl;
	private int currentIndex = -1;
	private int size = 0;

	public IteratorImpl(CreateIteratorImpl createIteratorImpl) {
		this.createIteratorImpl = createIteratorImpl;
		this.size = this.createIteratorImpl.size();
	}

	@Override
	public boolean hasNext() {
		return this.size > 0;
	}

	@Override
	public String next() {
		this.currentIndex++;
		this.size--;
		return this.createIteratorImpl.getItemAtIndex(this.currentIndex);
	}
}
