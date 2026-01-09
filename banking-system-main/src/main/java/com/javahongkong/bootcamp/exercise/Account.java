package com.javahongkong.bootcamp.exercise;

import java.math.BigDecimal;

public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		// complete the constructor
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
		// complete the function
		return attemptedPin == pin;
	}

	public double getBalance() {
		return balance;
	}

	public int getPin() {
		return pin;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void creditAccount(double amount) {
		// complete the function
		// BigDecimal
		balance = BigDecimal.valueOf(balance).add(BigDecimal.valueOf(amount)).doubleValue();
	}

	public boolean debitAccount(double amount) {
		// complete the function
		if (balance < amount) return false;
		balance = BigDecimal.valueOf(balance).subtract(BigDecimal.valueOf(amount)).doubleValue();
		return true;
	}
}
