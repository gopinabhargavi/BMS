package com.model;
public class SavingsAccount extends Account {
	private static final double MINIMUM_BALANCE =1000.00;
	public SavingsAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}

	@Override
	public void withdraw(double amount) {
		if(getBalance() - amount >= MINIMUM_BALANCE) {
			setBalance(getBalance() - amount);
			System.out.println("Amount withdrawn successfully....");
		}else {
			System.out.println("Insufficient funds...");
		}
		
	}

}
