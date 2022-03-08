package com.example.designPattern.compositePattern;

public class CurrentAccount implements Account {
	private int balance;
	private String bank;
	public CurrentAccount(int balance, String bank) {
		this.balance = balance;
		this.bank = bank;
	}
	@Override
	public void showAccountDetails() {
		System.out.println("Current account with bank " + bank + " with balance " + balance);
	}
}
