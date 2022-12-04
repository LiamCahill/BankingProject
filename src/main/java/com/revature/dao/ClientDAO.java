package com.revature.dao;

import com.revature.model.Account;
import com.revature.model.Client;

public interface ClientDAO {
    //What functionality involves clients?
    /*
    1. A new client gained.
    2. A client account is closed.
    3.
     */

    public boolean validateClient(Client client);
    int createClient(Client client);


}
