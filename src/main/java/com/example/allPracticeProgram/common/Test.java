package com.example.allPracticeProgram.common;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {

		String s = ")}";
		Stack<String> b = new Stack<String>();
		char[] character = s.toCharArray();

		boolean isRight = true;
		for (int i = 0; i < character.length; i++) {
			String ch = String.valueOf(character[i]);
			
			if (ch.equals("{") || ch.equals("(") || ch.equals("[")) {
				b.push(String.valueOf(ch));
			}
			
			String  pop = null;
			
			if (ch.equals("}")) {
				if(!b.isEmpty()) {
					pop = b.pop();	
				}
				else {
					isRight = false;
					break;
				}
				if(!pop.equals("{")) {
					isRight = false;
					break;
				}
				
			}
			if (ch.equals("]")&& !b.isEmpty()) {
				if(!b.isEmpty()) {
					pop = b.pop();	
				}
				else {
					isRight = false;
					break;
				}
				if(!pop.equals("[")) {
					isRight = false;
					break;
				}
			}
			if (ch.equals(")") && !b.isEmpty()) {
				if(!b.isEmpty()) {
					pop = b.pop();	
				}
				else {
					isRight = false;
					break;
				}
				if(!pop.equals("(")) {
					isRight = false;
					break;
				}
			}

		
			
		}
		
		if(!isRight) {
			System.out.println("Not In Good Order");
		}
		else {
			System.out.println("In Good Order");
		}

	}
	
	

}
