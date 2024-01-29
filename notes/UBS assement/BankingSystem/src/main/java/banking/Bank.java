package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	int consumerAccountNumber = 0;
	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long actNumber = Long.valueOf(++consumerAccountNumber);
		this.accounts.put(actNumber, new CommercialAccount(company,actNumber,pin,startingDeposit));
		return actNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long actNumber = Long.valueOf(++consumerAccountNumber);
		this.accounts.put(actNumber, new ConsumerAccount(person,actNumber,pin,startingDeposit));
		return actNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {

		if(accounts.get(accountNumber) != null){
			return accounts.get(accountNumber).validatePin(pin);
		}
		return false;
	}

	public double getBalance(Long accountNumber) {
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		return accounts.get(accountNumber).debitAccount(amount);
	}
}
