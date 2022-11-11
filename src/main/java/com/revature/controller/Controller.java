package com.revature.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.service.AccountService;
import com.revature.service.AccountServiceImpl;

public class Controller {
	private static final Logger LOGGER = Logger.getLogger(Controller.class);
	private static Account userAccount = null;
	private static AccountService accountService = new AccountServiceImpl();

	public void console() {

		userAccount = new Account();
		userAccount.setEmail("dec");
		userAccount.setPassword("lan");
		int balance = 0;

		Scanner scanner = new Scanner(System.in);
		LOGGER.trace("Attempting to connect to ONEBANK.");

		try (Connection connection = MyConnection.getConnection()) {
			LOGGER.info("You are connected!");
		} catch (SQLException e) {
			LOGGER.error("Issue connecting to ONEBANK.", e);
		}

		System.out.println("Please select an option from the following list:");
		System.out.println("[1].Logon.");
		System.out.println("[2].Create an account.");
		System.out.println("[3].Exit the program.");

		String input = scanner.nextLine();
		System.out.println(input);

		if (input.equals("1")) {
			System.out.println("Please enter in your username.");
			String username = scanner.nextLine();
			System.out.println("Please enter in your password.");
			String password = scanner.nextLine();

			Account userAccount2 = new Account(username, balance, password);

			System.out.println("Logged in status = " + accountService.loggedIn(userAccount2));
			if (accountService.loggedIn(userAccount2) == false) {
				System.out.println("Login failed. Please exit the application and retry.");
				System.exit(0);
			}

			System.out.println("Select from the following options:");
			System.out.println("[1]. Deposit into account");
			System.out.println("[2]. Withdraw from account");
			System.out.println("[3]. View transactions history");
			System.out.println("[4]. Get balance.");

			String accountOptions = scanner.nextLine();

			if (accountOptions.equals("1")) {
				System.out.println("How much would you like to deposit?");
				String amount = scanner.nextLine();
				int depositAmount = Integer.parseInt(amount);
				accountService.depositAccount(userAccount2, depositAmount);

			} else if (accountOptions.equals("2")) {
				System.out.println("How much would you like to withdraw?");
				String amount = scanner.nextLine();
				int withdrawAmount = Integer.parseInt(amount);
				accountService.withdrawAccount(userAccount2, withdrawAmount);

			} else if (accountOptions.equals("3")) {
				// accountService.viewTransaction(userAccount2);

			} else if (accountOptions.equals("4")) {
				System.out.println(userAccount2.getBalance());
			} else {
				System.out.println("Input not accepted.");
			}

		} else if (input.equals("2")) {
			System.out.println("Creating account...");
			System.out.println("Please enter your email address. ");
			String useremail = scanner.nextLine();
			System.out.println("Please enter a password for your account. ");
			String userpassword = scanner.nextLine();

			userAccount = new Account(useremail, 0, userpassword);

			accountService.createAccount(userAccount);

		} else if (input.equals("3")) {
			System.out.println("Your session has been closed.");
			System.exit(0);
		}

		scanner.close();
	}
}
