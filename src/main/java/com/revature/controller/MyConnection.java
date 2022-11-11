package com.revature.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

//import oracle.jdbc.logging.annotations.Log;

//import org.apache.log4j.Logger;

public class MyConnection {
	private static final Logger LOGGER = Logger.getLogger(MyConnection.class);

	// private AnimalDao dao = new AnimalDaoJdbc();
	public static Connection getConnection() throws SQLException {

		String url = System.getenv("BANKLIAM_URLSQL");
		String user = System.getenv("BANKLIAM_USERSQL");
		String password = System.getenv("BANKLIAM_PASSWORDSQL");
		LOGGER.trace("Testing connection...");
		return DriverManager.getConnection(url, user, password);
	}
}
