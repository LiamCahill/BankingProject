package com.revature.service;

import java.util.Set;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoJdbc;
import com.revature.model.Account;

public class AccountServiceImpl implements AccountService {

	boolean isLoggedIn = false;

	
	public AccountServiceImpl() {
		super();
	}
	
	
	public AccountDao dao = new AccountDaoJdbc();

	public long depositAccount(Account account, int deposit) {
		double bal = account.getBalance();
		bal = bal + deposit;
		account.setBalance(bal);
		
		return dao.depositAccount(account, deposit);
	}

	@Override
	public long withdrawAccount(Account account, int withdraw) {
		double bal = account.getBalance();
		bal = bal - withdraw;
		account.setBalance(bal);
		
		return dao.withdrawAccount(account, withdraw);
		

	}

	public int createAccount(Account account) {
		System.out.println("Processing in ASI");
		return dao.createAccount(account);
	}
	
	@Override
	public Set<Account> viewTransaction() {
		return null;
	}

	@Override
	public boolean loggedIn(Account account) {
		isLoggedIn = dao.validateAccount(account);
		return isLoggedIn;
	}
	public boolean viewBalance(Account account) {
		return false;
	}

}
