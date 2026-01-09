package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface {
	private static Long nextAccountNumber = 1L;
	private LinkedHashMap<Long, Account> accounts; // object reference

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = nextAccountNumber++;
		CommercialAccount commercialAccount = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, commercialAccount);
		return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = nextAccountNumber++;
		ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, consumerAccount);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account lookupAccount = accounts.get(accountNumber);
		if (lookupAccount == null) return false;
		return lookupAccount.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account lookupAccount = accounts.get(accountNumber);
		if (lookupAccount == null) return;
		lookupAccount.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account lookupAccount = accounts.get(accountNumber);
		if (lookupAccount == null) return false;
		return lookupAccount.debitAccount(amount);
	}

	public LinkedHashMap<Long, Account> getAccounts() {
		return accounts;
	}
}
