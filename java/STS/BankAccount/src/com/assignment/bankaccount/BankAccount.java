package com.assignment.bankaccount;

import java.util.Random;

public class BankAccount {
	String accountNumber;
	double checkingBalance;
	double savingsBalance;
	private static int numOfAccounts = 0;
	private static int totBalance = 0;
	
	public BankAccount() {
		accountNumber = random();
		numOfAccounts++;
	}
	
	public static int bACount(){
		return numOfAccounts;	
	}
	
	private String random() {
		String set = "0123456789abcdefghijklmnopqrstuvwxyz"; // creating a string of characters
		StringBuilder sb = new StringBuilder(); // creates a new string
		Random r = new Random(); // sets random
		int n = 10;
		for (int i = 0; i <= n; i++) { 
			int index = r.nextInt(set.length()); // generates a random num in set between 0 and its length)
			char c = set.charAt(index); // assigns the random char index to c 
			sb.append(c);  // appends to c
		}
		return (sb.toString());
	}
	
	public double getChkBal() {
		return this.checkingBalance;
	}
	
	public double getSavBal() {
		return this.savingsBalance;
	}
	
	public void deposit(String account, double amount) {
		if (account == "Checking"){
			this.checkingBalance += amount;
		}
		else {
			this.savingsBalance += amount;
		}
		totBalance += amount;
	}
	
	public void withdrawChk(double chk) {
		if (chk > this.checkingBalance) { 
			System.out.println("You don't have enough funds. Your current checking acct. balance is : " + this.checkingBalance);
		} else {
			this.checkingBalance -= chk;
			totBalance -= totBalance;
		}
	}
	public void viewBalance() {
		System.out.println("Checking acct. balance: " + this.getChkBal());
		System.out.println("Savings acct. balance: " + this.getSavBal());
	}

	public static int getTotBalance() {
		return totBalance;
	}

	private static void setTotBalance(double d) {
		BankAccount.totBalance = (int) d;
	}
}
