package com.example.designPattern.compositePattern;

public class SavingAccount implements Account {
	private int balance;
	private String bank;
	public SavingAccount(int balance, String bank) {
		this.balance = balance;
		this.bank = bank;
	}
	@Override
	public void showAccountDetails() {
		System.out.println("Saving account with bank " + bank + " with balance " + balance);
	}
}
