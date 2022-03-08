package com.example.designPattern.chainOfResponsibilityPattern;

public class Multiplication implements Chain{
	
	Chain chain;
	@Override
	public void nextChain(Chain chain) {
		this.chain =  chain;
	}

	@Override
	public void performOperation(Numbers numbers) {

		if(numbers.getOperation().equals("mult")) {
			System.out.println(numbers.getNumber1()+" * "+numbers.getNumber2()+" = "+(numbers.getNumber1()*numbers.getNumber2()));
		}
		else {
			chain.performOperation(numbers);
		}
	}
}
