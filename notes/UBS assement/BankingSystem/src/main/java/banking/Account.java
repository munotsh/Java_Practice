package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		return this.pin == attemptedPin;
	}

	public double getBalance() {
		return balance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void creditAccount(double amount) {
		this.balance+=amount;
	}

	public boolean debitAccount(double amount) {
		if(this.balance>=amount){
			this.balance = this.balance - amount;
			return true;
		}
		return false;
	}
}
