package com.example.designPattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Account {
	List<Account> accounts = new ArrayList<Account>();
	public void addAcount(Account account) {
		accounts.add(account);
	}
	public void remove(Account account) {
		accounts.remove(account);
	}
	@Override
	public void showAccountDetails() {
		for (Account account : accounts) {
			account.showAccountDetails();
		}
	}
}
