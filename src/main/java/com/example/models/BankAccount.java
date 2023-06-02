package com.example.models;

public class BankAccount {
    private int id;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(int id, String accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

	public BankAccount orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}

