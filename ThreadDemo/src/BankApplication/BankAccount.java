package BankApplication;

public class BankAccount {
	private double balance;
	public BankAccount(double balance) {
		this.balance=balance;
	}
	public synchronized void withdraw(double amount) {
		System.out.println(Thread.currentThread().getName()+" wants to withdraw Rs."+amount);
		while(balance<amount) {
			System.out.println("Insufficient Balance.");
			System.out.println(Thread.currentThread().getName()+" waiting for the deposite");
			
			try {
				wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void deposite(double amount) {
		System.out.println(Thread.currentThread().getName()+" Depositing amount Rs. "+amount);
		balance+=amount;
		
		System.out.println("Updated balance = Rs."+balance);
		System.out.println("Notifying wating customer...");
		notifyAll();
	}
	public synchronized void checkBalance() {
		System.out.println("current balance = Rs."+balance);
	}

}
