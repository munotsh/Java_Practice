package com.example.designPattern.chainOfResponsibilityPattern;

public class Subtraction implements Chain{
	
	Chain chain;
	@Override
	public void nextChain(Chain chain) {
		this.chain =  chain;
	}

	@Override
	public void performOperation(Numbers numbers) {

		if(numbers.getOperation().equals("sub")) {
			System.out.println(numbers.getNumber1()+" - "+numbers.getNumber2()+" = "+(numbers.getNumber1()-numbers.getNumber2()));
		}
		else {
			chain.performOperation(numbers);
		}
	}
}
