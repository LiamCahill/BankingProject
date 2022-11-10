package com.revature.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.model.Account;
import com.revature.service.AccountServiceImpl;
public class AccountServiceImplTest {

	private static Logger LOGGER = Logger.getLogger(AccountServiceImplTest.class);


	public class AccountServiceTest {


		private AccountServiceImpl service;
		private Account mockAccount;


		@Before
		public void setUp() {
			service = new AccountServiceImpl();
			mockAccount = new Account("testemail.com", 0, "password");

		}
/*
		@Test
		public void getBalanceofUser() throws SQLException{
			assertEquals(10, mockAccount.getBalance());
		}
		
		@Test
		public void depositIntoAccount(mockAccount, 10) throws SQLException {
			assertEquals( accountService.depositAccount(userAccount2, depositAmount), actual);;
		}
*/
		@After
		public void tearDown() {
			service = null;

		}
	}

}
