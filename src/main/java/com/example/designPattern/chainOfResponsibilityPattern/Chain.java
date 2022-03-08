package com.example.designPattern.chainOfResponsibilityPattern;

public interface Chain {
	public void nextChain(Chain chain);
	public void performOperation(Numbers num);

}
