package BankApplication;

public class Withdraw extends Thread{
	private double amount;
	private BankAccount account;
	public Withdraw( String name, double amount, BankAccount account) {
		super(name);
		this.amount = amount;
		this.account = account;
	}
	public void run() {
		account.withdraw(amount);
	}

}
