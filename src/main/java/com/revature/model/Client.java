package com.revature.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Client {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate DOB;
    private int number_of_accounts;
    private int balance;


    public Client(){
    };

    public Client(String name, String email, String phoneNumber, String password, LocalDate DOB, int number_of_accounts, int balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.DOB = DOB;
        this.number_of_accounts = 1;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getNumber_of_accounts() {
        return number_of_accounts;
    }

    public void setNumber_of_accounts(int number_of_accounts) {
        this.number_of_accounts = number_of_accounts;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return number_of_accounts == client.number_of_accounts && balance == client.balance && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(password, client.password) && Objects.equals(DOB, client.DOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber, password, DOB, number_of_accounts, balance);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", DOB=" + DOB +
                ", number_of_accounts=" + number_of_accounts +
                ", balance=" + balance +
                '}';
    }
}
