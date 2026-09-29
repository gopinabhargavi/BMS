package com.view;
import java.util.Scanner;
import com.service.BankingServcie;
public class BankingManagementSystem {
	public static void main(String[] args) {
		BankingServcie service = new BankingServcie();
		Scanner obj = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("*************************************");
			System.out.println("*************************************");
			System.out.println("*********** Welcome to **************");
			System.out.println("*******Banking Managemt System ******");
			System.out.println("******** 1. Create Customer *********");
			System.out.println("******** 2. Create Account  *********");
			System.out.println("******** 3. Deposit Amount  *********");
			System.out.println("******** 4. Withdraw Amount *********");
			System.out.println("******** 5. View Balance    *********");
			System.out.println("******** 6. View Accounts   *********");
			System.out.println("******** 7. EXIT            *********");
			System.out.println("*************************************");
			System.out.println("*************************************");
			
			choice = obj.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter customer id:");
					String cus_id = obj.next();
					System.out.println("Enter customer name:");
					String cus_name = obj.next();
					service.createCustomer(cus_id, cus_name);
					break;
				case 2:
					System.out.println("Enter customer id:");
					cus_id = obj.next();
					System.out.println("Enter account number:");
					String acc_number = obj.next();
					System.out.println("Enter account type:");
					String acc_type = obj.next();
					System.out.println("Enter balance:");
					double balance = obj.nextDouble();
					service.createAccount(cus_id, acc_type, acc_number, balance);
					break;
				case 3:
					System.out.println("Enter Account Number");
					String dep_acc_no = obj.next();
					System.out.println("Enter amount");
					double dep_amount = obj.nextDouble();
					service.deposit(dep_acc_no, dep_amount); 
					break;
				case 4:
					System.out.println("Enter Account Number");
					String w_acc_no = obj.next();
					System.out.println("Enter amount");
					double w_amount = obj.nextDouble();
					service.withdraw(w_acc_no, w_amount);
					break;
				case 5:
					System.out.println("Enter Account Number");
					String acc_no = obj.next();
					service.viewBalance(acc_no);
					break;
				case 6:
					service.viewAccounts();
					break;
				case 7:
					System.out.println("Thanks for using BMS");
					return;	
				default:
					System.out.println("Please enter valid choice");
			}
		}

	}

}
