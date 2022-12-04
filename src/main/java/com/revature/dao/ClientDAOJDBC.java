package com.revature.dao;

import java.sql.Connection;
import java.util.Set;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.revature.model.Account;
import com.revature.model.Client;
import org.apache.log4j.Logger;
import com.revature.controller.MyConnection;


public class ClientDAOJDBC implements ClientDAO {

    private static Logger LOGGER = Logger.getLogger(ClientDAOJDBC.class);


    @Override
    public boolean validateClient(Client client) {
        return false;
    }

    @Override
    public int createClient(Client client) {
        try (Connection connection = MyConnection.getConnection()) {
            int index = 0;

            String sql1 = "SELECT * FROM clients WHERE email = ?";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, client.getEmail());
            if (statement1.executeUpdate() > 0) {
                System.out.println("Client already exists in the system.");

                return 0;
            } else {

                String sql = "INSERT INTO clients(c_name, c_email, c_password, c_dob, c_balance) VALUES (?,?,?,?,?)";
                System.out.println("Before SQL call");
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(++index, client.getName());
                statement.setString(++index, client.getEmail());
                statement.setString(++index, client.getPassword());
                statement.setDate(++index, (Date) client.getDOB());
                statement.setInt(++index, client.getBalance());


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



}
