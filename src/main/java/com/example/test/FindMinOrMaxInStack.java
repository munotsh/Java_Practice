package com.example.test;

public class FindMinOrMaxInStack {

	static final int MAX = 1000;
	int top = -1;
	int[] stack;
	int[] maxstack;
	int[] minstack;

	public FindMinOrMaxInStack() {
		this(MAX);
	}

	public FindMinOrMaxInStack(int size) {
		stack = new int[size];
		maxstack = new int[size];
		minstack = new int[size];
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public void push(int v) {
		if (top == stack.length - 1) {
			System.out.println("Overflow!!");
			return;
		}
		stack[++top] = v;
		if (top == 0 || v >= maxstack[top - 1]) {
			maxstack[top] = v;
		} else {
			maxstack[top] = maxstack[top - 1];
		}
		if (top == 0 || v <= minstack[top - 1]) {
			minstack[top] = v;
		} else {
			minstack[top] = minstack[top - 1];
		}
	}

	public int pop() {
		if (top < 0) {
			System.out.println("Empty stack");
			return 0;
		}
		return stack[top--];
	}

	public String getMax() {
		if (!isEmpty())
			return maxstack[top] + "";
		return "Stack is Empty";
	}

	public String getMin() {
		if (!isEmpty())
			return minstack[top] + "";
		return "Stack is Empty";
	}

	public static void main(String[] args) {
		FindMinOrMaxInStack st = new FindMinOrMaxInStack();
		st.push(2);
		st.push(1);
		st.push(6);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.pop();
		st.push(3);
		st.push(5);
		st.push(0);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
	}
}
