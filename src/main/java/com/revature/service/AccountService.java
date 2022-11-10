package com.revature.service;

import java.util.Set;

import com.revature.model.Account;

public interface AccountService {

	public long depositAccount(Account account, int deposit);
	
	public long withdrawAccount(Account account, int withdraw);
	
	public Set<Account> viewTransaction();
	
	public int createAccount(Account account);
	
	public boolean loggedIn(Account account);
		

}
