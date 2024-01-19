package com.example.allPracticeProgram.amazon;

public class FindMinStack {
	static final int MAX = 1000;
	int top = -1;
	int[] stack;
	int[] maxstack;
	int[] minstack;

	public FindMinStack() {
		this(MAX);
	}

	public FindMinStack(int size) {
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
		// TODO Auto-generated method stub
		FindMinStack st = new FindMinStack();
		st.push(2);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.push(1);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.push(6);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.pop();
		st.pop();
		st.pop();
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.push(3);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.push(5);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
		st.push(0);
		System.out.println("max = " + st.getMax() + " and min = " + st.getMin());
	}
}
