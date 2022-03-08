package com.example.designPattern.chainOfResponsibilityPattern;

public class Addition implements Chain{

	Chain chain;
	@Override
	public void nextChain(Chain chain) {
		this.chain =  chain;
	}

	@Override
	public void performOperation(Numbers numbers) {

		if(numbers.getOperation().equals("Add")) {
			System.out.println(numbers.getNumber1()+" + "+numbers.getNumber2()+" = "+(numbers.getNumber1()+numbers.getNumber2()));
			
		}
		else {
			chain.performOperation(numbers);
		}
	}

}
