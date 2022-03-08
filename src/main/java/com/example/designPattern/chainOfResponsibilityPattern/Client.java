
package com.example.designPattern.chainOfResponsibilityPattern;

public class Client {

	public static void main(String[] args) {

		Chain add = new Addition();
		Chain sub = new Substractions();
		Chain mult = new Multiplication();
		Chain div = new Divission();
		
		add.nextChain(sub);
		sub.nextChain(mult);
		mult.nextChain(div);
		
		Numbers num = new Numbers(2, 2, "abc");
		add.performOperation(num);
	}

}
