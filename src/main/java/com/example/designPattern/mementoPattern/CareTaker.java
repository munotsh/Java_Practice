package com.example.designPattern.mementoPattern;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<String> history;
	private int currentIndex = -1;

	public CareTaker() {
		this.history = new ArrayList<String>();
	}

	public void addMemento(String m) {
		this.history.add(m);
		currentIndex++;
	}

	public String getMemento(int index) {
		return this.history.get(index);
	}

	public String undo() {
		System.out.println("-----undoing memonto-----");
		if (currentIndex <= 0) {
			currentIndex = 0;
			return getMemento(currentIndex);
		}
		currentIndex--;
		return getMemento(currentIndex);
	}

	public String redo() {
		System.out.println("-----rdoing memonto-----");
		if (currentIndex >= this.history.size() - 1) {
			currentIndex = this.history.size() - 1;
			return getMemento(currentIndex);
		}
		currentIndex++;
		return getMemento(currentIndex);
	}
}
