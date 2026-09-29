package com.model;
public class CurrentAccount extends Account {
	private static final double OVER_DRAFT_LIMIT = -5000.00;
	public CurrentAccount(String accountNumber, Customer customer, double balance) {
		super(accountNumber, customer, balance);
	}
	@Override
	public void withdraw(double amount) {
		if(getBalance() - amount >= OVER_DRAFT_LIMIT) {
			setBalance(getBalance() - amount);
			System.out.println("Amount withdrawn successfully....");
		}else {
			System.out.println("Over draft limit exceeded...");
		}
	}

}
