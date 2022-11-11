package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable {

	private String email;
	private double balance;
	private String password;
	// private ArrayList<Transaction> transactions;

	private static final long serialVersionUID = 5426L;

	public Account() {
	}

	public Account(String email, double balance, String password) {
		super();
		this.email = email;
		this.balance = balance;

		this.password = password;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//
	// public ArrayList<Transaction> getTransactions() {
	// return transactions;
	// }

	//
	// public void setTransactions(ArrayList<Transaction> transactions) {
	// this.transactions = transactions;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		// result = prime * result + ((transactions == null) ? 0 :
		// transactions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		// if (transactions == null) {
		// if (other.transactions != null)
		// return false;
		// } else if (!transactions.equals(other.transactions))
		// return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", balance=" + balance + ", password=" + password + "]";
	}

}
