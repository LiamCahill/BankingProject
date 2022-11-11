package com.revature.dao;

import com.revature.model.Account;

public interface AccountDao {

	long depositAccount(Account account, int deposit);

	long withdrawAccount(Account account, int withdraw);

	int createAccount(Account account);

	public boolean viewTransactions(Account account);

	public boolean validateAccount(Account account);

}
