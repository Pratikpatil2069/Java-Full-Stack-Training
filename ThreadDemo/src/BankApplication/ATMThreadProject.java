package BankApplication;

import java.util.Scanner;

public class ATMThreadProject {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Amount:");
		double amount=sc.nextDouble();
		BankAccount account=new BankAccount(amount);
		Withdraw customer1=new Withdraw("Pratik",15000,account);
		Deposite customer2=new Deposite("Aditya",10000,account);
		customer1.start();
		try {
			Thread.sleep(300);
		}catch(Exception e) {
			e.printStackTrace();
		}
		customer2.start();
	}

}
