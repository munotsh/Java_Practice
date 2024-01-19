package com.example.designPattern.chainOfResponsibilityPattern;

public class Divisions implements Chain{
	Chain chain;
	@Override
	public void nextChain(Chain chain) {
		this.chain =  chain;
	}

	@Override
	public void performOperation(Numbers numbers) {

		if(numbers.getOperation().equals("Div")) {
			System.out.println(numbers.getNumber1()+" / "+numbers.getNumber2()+" = "+(numbers.getNumber1()/numbers.getNumber2()));
		}
		else {
			System.out.println("only add, sub, mult and div is allowed");
		}
	}
}
