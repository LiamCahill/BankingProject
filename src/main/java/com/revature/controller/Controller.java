package com.revature.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.revature.model.Client;
import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.service.AccountService;
import com.revature.service.AccountServiceImpl;

public class Controller {
	private static final Logger LOGGER = Logger.getLogger(Controller.class);
	private static Client admin = null;
	private static AccountService accountService = new AccountServiceImpl();

	public void console() {

		//TODO I may need to create this account before being able to log on.
		admin = new Client();
		admin.setEmail("cahill.liam220@gmail.com");
		admin.setPassword("cahill");
		int balance = 0;

		Scanner scanner = new Scanner(System.in);
		LOGGER.trace("Attempting to connect to CAA Client database...");

		try (Connection connection = MyConnection.getConnection()) {
			LOGGER.info("You are connected!");
		} catch (SQLException e) {
			LOGGER.error("Issue connecting to CAA Client database.", e);
			System.exit(0);
		}

		System.out.println("Please select an option from the following list:");
		System.out.println("[1].Create a client.");
		System.out.println("[2].Exit the program.");

		String input = scanner.nextLine();


		if (input.equals("1")) {
			System.out.println("Please enter your name.");
			String name = scanner.nextLine();
			System.out.println("Please enter your email.");
			String email = scanner.nextLine();
			System.out.println("Please enter your password.");
			String password = scanner.nextLine();
			System.out.println("Please enter in your phone number. (ex.123-456-7890)");
			String phone = scanner.nextLine();
			LocalDate dateOfBirth;

			try {
				System.out.println("Please enter in your date of birth (YYYY-MM-DD)");
				String dob_raw = scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM", Locale.ENGLISH);
				dateOfBirth = LocalDate.parse(dob_raw, formatter);
			} catch (Exception e){
				//Intend here is to set DOB to a default if the initially entered date isn't accepted.
				System.out.println("Date format invalid.");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM", Locale.ENGLISH);
				dateOfBirth = LocalDate.parse("1900-01-01", formatter);
			}

			Client client1 = new Client(name, email, phone, password, dateOfBirth, 1, 0);


			scanner.close();
		}
	}
}
