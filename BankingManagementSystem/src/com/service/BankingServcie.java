package com.service;
import java.util.LinkedHashMap;
import com.model.Account;
import com.model.CurrentAccount;
import com.model.Customer;
import com.model.SavingsAccount;
public class BankingServcie {
	private LinkedHashMap<String, Customer> customers;
	private LinkedHashMap<String, Account> accounts;
	public BankingServcie() {
		customers = new LinkedHashMap<String, Customer>();
		accounts = new LinkedHashMap<String, Account>();
	}
	public void createCustomer(String cus_id, String cus_name) {
		if(customers.containsKey(cus_id)) {
			System.out.println("Customer id already exist....");
		}else {
			Customer obj = new Customer(cus_id, cus_name);
			customers.put(cus_id, obj);
			System.out.println("Customer created Successfully....");
		}
		
	}
	public void createAccount(String cus_id, String acc_type, String acc_number, double balance) {
		if(customers.containsKey(cus_id)) {
			if(accounts.containsKey(acc_number)) {
				System.out.println("Account number already exist....");
			}else {
				Account account;
				Customer obj = customers.get(cus_id);
				if(acc_type.equalsIgnoreCase("Savings")) {
					account = new SavingsAccount(acc_number, obj, balance);
					accounts.put(acc_number, account);
					System.out.println("Savings Account created....");
				}else if(acc_type.equalsIgnoreCase("Current")) {
					account = new CurrentAccount(acc_number, obj, balance);
					accounts.put(acc_number, account);
					System.out.println("Current Account created....");
				}else {
					System.out.println("Invalid account type......");
				}
			}
		}else {
			System.out.println("Customer id not exist....");
		}
		
	}
	public void deposit(String dep_acc_no, double dep_amount) {
	 if(accounts.containsKey(dep_acc_no)) {
		 Account account = accounts.get(dep_acc_no);
		 account.deposit(dep_amount);
	 }else {
		 System.out.println("Account number not found....");
	 }	
	}
	public void withdraw(String w_acc_no, double w_amount) {
		 if(accounts.containsKey(w_acc_no)) {
			 Account account = accounts.get(w_acc_no);
			 account.withdraw(w_amount);
		 }else {
			 System.out.println("Account number not found....");
		 }		
	}
	public void viewBalance(String acc_no) {
		if(accounts.containsKey(acc_no)) {
			 Account account = accounts.get(acc_no);
			 System.out.println("Avaliable Balance");
			 System.out.println(account.getBalance());
		 }else {
			 System.out.println("Account number not found....");
		 }
	}
	public void viewAccounts() {
	 for(Account account : accounts.values()) {
		 System.out.println(account);
	 }	
	}
}
