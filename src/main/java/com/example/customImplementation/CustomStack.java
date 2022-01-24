package com.example.customImplementation;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CustomStack<T>{
	ArrayList<T> stack;
	int capacity;

	public CustomStack(int cap) {
		capacity = cap;
		stack = new ArrayList<T>();
	}


	public void push(T t) {
		if(isFull()) {
			System.out.println("stack is full");
			return;
		}
		stack.add(t);
	}

	private boolean isFull() {
		return capacity == this.stack.size();
	}

	public T pop() {
		if(this.stack.size() == 0) {
			System.out.println("stack is empty");
			throw new RuntimeException("Stack is Empty");
		}
		T t = this.stack.get(this.stack.size()-1);
		this.stack.remove(this.stack.size()-1);
		return t;
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public T peek(){
		if(this.stack.size() == 0) {
			System.out.println("stack is empty");
			throw new RuntimeException("Stack is Empty");
		}
		return this.stack.get(this.stack.size()-1);
	}

	public static void main(String[] args) {
		CustomStack<Integer> st = new CustomStack<Integer>(5);

		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
	}
}
