package com.revature.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.Account;
import com.revature.service.AccountService;
import com.revature.service.AccountServiceImpl;


public class MyConnection {
	private static final Logger LOGGER = Logger.getLogger(MyConnection.class);

	//private AnimalDao dao = new AnimalDaoJdbc();
	
	public static Connection getConnection() throws SQLException {
		String url = System.getenv("BANKLIAM_URLSQL") ;
		String user = System.getenv("BANKLIAM_USERSQL");	
		String password = System.getenv("BANKLIAM_PASSWORDSQL");

		return DriverManager.getConnection(url, user, password);
	}
}
