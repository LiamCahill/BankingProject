package com.revature.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class MyConnection {
	private static final Logger LOGGER = Logger.getLogger(MyConnection.class);

	// private AnimalDao dao = new AnimalDaoJdbc();
	public static Connection getConnection() throws SQLException {

		// String url = System.getenv("BANKLIAM_URLSQL");
		// String user = System.getenv("BANKLIAM_USERSQL");
		// String password = System.getenv("BANKLIAM_PASSWORDSQL");

		//TODO Update the database info below to use Oracle database instead of Postgres.
		String url = "postgres://postgres:postgrespw@localhost:55000";
		String user = "postgres";
		String password = "postgrespw";

		LOGGER.trace("Testing connection...");
		return DriverManager.getConnection(url, user, password);
	}
}
