package com.assignment.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount new1 = new BankAccount();
		System.out.println("Checking acct. balance: " + new1.getChkBal());
		System.out.println("Savings acct. balance: " + new1.getSavBal());
		new1.deposit("Checking", 100);
		System.out.println("New checking balance: " + new1.getChkBal());
		new1.deposit("Savings", 100.00);
		System.out.println("New saving balance: " + new1.getSavBal());
		new1.withdrawChk(50);
		System.out.println("New checking balance: " + new1.getChkBal());
		new1.viewBalance();
	}

}
