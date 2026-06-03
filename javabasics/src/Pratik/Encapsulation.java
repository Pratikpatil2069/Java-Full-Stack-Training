package Pratik;

class Bank{
	Bank(){}
	private int accNo;
	private int balance;
	
	public void setAccNo(int accNo) {
		this.accNo=accNo;
	}
	public void setBalance(int balance) {
			this.balance=balance;
	}
	public int getAccNo() {
		return this.accNo;
	}
	public int getBalance() {
		return this.balance;
	}
	
}
public class Encapsulation {
	

	public static void main(String[] args) {
		Bank b=new Bank();
		b.setAccNo(1204893578);
		b.setBalance(2344);
		System.out.println("Account No:"+b.getAccNo());
		System.out.println("Total Balance :"+b.getBalance());

	}

}

