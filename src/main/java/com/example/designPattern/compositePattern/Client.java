package com.example.designPattern.compositePattern;

public class Client {

	public static void main(String[] args) {
		SavingAccount s1 = new SavingAccount(1000, "SBI");
		SavingAccount s2 = new SavingAccount(2000, "CITI");
		SavingAccount s3 = new SavingAccount(3000, "DB");
		CurrentAccount c1 = new CurrentAccount(4000, "HSBC");
		CurrentAccount c2 = new CurrentAccount(4000, "JPMC");
		BankAccount bankAccount = new BankAccount();
		bankAccount.addAcount(s1);
		bankAccount.addAcount(s2);
		bankAccount.addAcount(s3);
		bankAccount.addAcount(c1);
		bankAccount.addAcount(c2);
		bankAccount.showAccountDetails();
	}
}
