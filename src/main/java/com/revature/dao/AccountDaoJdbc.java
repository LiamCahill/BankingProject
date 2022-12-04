package com.revature.dao;

import java.sql.Connection;
import java.util.Set;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.revature.controller.MyConnection;
import com.revature.model.Account;

public class AccountDaoJdbc implements AccountDao {
	private static Logger LOGGER = Logger.getLogger(AccountDaoJdbc.class);

	// Removed the below line to correct for compilation errors.
	// private Account account = new Account();

	@Override
	public boolean viewTransactions(Account account) {
		int index = 0;
		try (Connection connection = MyConnection.getConnection()) {
			String query = "SELECT * FROM TRANSACTION WHERE A_EMAIL = ?";

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(++index, account.getEmail());

			if (statement.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			LOGGER.error("Exception thrown when withdrawing money into your account.", e);
		}
		return false;
	}

	@Override
	public long depositAccount(Account account, int deposit) {
		try (Connection connection = MyConnection.getConnection()) {
			int index = 0;
			LOGGER.info("Made it through the try.");
			String sqlDeposit = "INSERT INTO TRANSACTION(A_EMAIL,T_TIMESTAMP,T_AMOUNT) VALUES (?,CURRENT_TIMESTAMP,?)";

			PreparedStatement statement1 = connection.prepareStatement(sqlDeposit);
			statement1.setString(++index, account.getEmail());
			statement1.setDouble(++index, deposit);
			// LOGGER.info("Successfully prepared the statement.");

			int index1 = 0;

			String sql3 = "UPDATE ACCOUNT SET A_BALANCE = A_BALANCE + ? WHERE ACCOUNT.A_EMAIL = ?";

			PreparedStatement statement2 = connection.prepareStatement(sql3);
			statement2.setDouble(++index1, deposit);
			statement2.setString(++index1, account.getEmail());

			if (statement1.executeUpdate() > 0) {
				System.out.println("Money has been deposited.");

				return 0;
			} else {

				return 0;
			}
		}

		catch (SQLException e) {
			LOGGER.error("Exception thrown when depositing money into account.", e);
		}
		return -1;
	}

	@Override
	public long withdrawAccount(Account account, int withdraw) {
		try (Connection connection = MyConnection.getConnection()) {
			int index = 0;

			String sqlDeposit = "INSERT INTO TRANSACTION(A_EMAIL,T_TIMESTAMP,T_AMOUNT) VALUES (?,CURRENT_TIMESTAMP,?)";

			PreparedStatement statement1 = connection.prepareStatement(sqlDeposit);
			statement1.setString(++index, account.getEmail());
			statement1.setDouble(++index, withdraw);

			int index1 = 0;

			String sql3 = "UPDATE ACCOUNT SET A_BALANCE = A_BALANCE - ? WHERE ACCOUNT.A_EMAIL = ?";

			PreparedStatement statement2 = connection.prepareStatement(sql3);
			statement2.setDouble(++index1, withdraw);
			statement2.setString(++index1, account.getEmail());

			if (statement1.executeUpdate() > 0) {
				System.out.println("Money has been withdrawn. Congrats on having any in the first place.");

				return 0;
			} else {

				return 0;
			}

		} catch (SQLException e) {
			LOGGER.error("Exception thrown when withdrawing money. Reason may include: Lack of sufficient funds.", e);
		}
		return -1;
	}

	@Override
	public int createAccount(Account account) {
		try (Connection connection = MyConnection.getConnection()) {
			int index = 0;

			String sql1 = "SELECT * FROM clients WHERE email = ?";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, account.getEmail());
			if (statement1.executeUpdate() > 0) {
				System.out.println("Account already exists.");

				return 0;
			} else {

				String sql = "INSERT INTO clients(name, email, password) VALUES (?,?,?)";
				System.out.println("before SQL call");
				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setDouble(++index, account.getBalance());
				statement.setString(++index, account.getEmail());
				statement.setString(++index, account.getPassword());

				System.out.println("After SQL call.");
				if (statement.executeUpdate() > 0) {
					System.out.println("Success.");
					return 0;
				}
				System.out.println("failed");
			}
		} catch (SQLException e) {

			LOGGER.error(e);
		}
		return -1;

	}

	public Set<Account> viewTransaction() {
		return null;
	}

	@Override
	public boolean validateAccount(Account account) {

		try (Connection connection = MyConnection.getConnection()) {
			int index = 0;
			String sql = "SELECT * FROM ACCOUNT WHERE A_EMAIL = ? AND A_PASSWORD = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++index, account.getEmail());
			statement.setString(++index, account.getPassword());

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {

			LOGGER.error(e);
		}
		return false;
	}

	public boolean viewBalance(Account account) {
		try (Connection connection = MyConnection.getConnection()) {
			int index = 0;
			String sql = "SELECT * FROM ACCOUNT WHERE A_EMAIL = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++index, account.getEmail());

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return true;
			}

		} catch (SQLException e) {

		}
		return false;
	}

}
