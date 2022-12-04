package com.revature.service;

import com.revature.dao.ClientDAO;
import com.revature.dao.ClientDAOJDBC;
import com.revature.model.Client;

public class ClientServiceImpl implements ClientService {

    public ClientDAO dao = new ClientDAOJDBC();

    @Override
    public int createClient(Client client) {
        System.out.println("Processing client creation request...");
        return dao.createClient(client);
    }
}
