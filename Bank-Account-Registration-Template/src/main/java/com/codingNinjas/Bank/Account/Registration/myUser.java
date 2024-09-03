package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of a User Interface based on the selection
 * done in the console for user information.You need to complete this class
 * based on the following tasks.
 * <p>
 * a. Adding common attributes:
 * 1. String name
 * 2. List<Account> accountList.
 * b. Override the methods of User Interface.
 * c. Build the logic for all the methods based on the description mentioned in the Account Interface.
 **/

public class myUser implements User {
    private String name;
    List<Account> accountList;
   public myUser(){
       accountList = new ArrayList<Account>();
   }
    public void init() {
        System.out.println("User bean has been instantiated and I'm the init() method");
    }

    public void destroy() {
        System.out.println("User bean has been closed and I'm the destroy() method");
    }
    @Override
    public void setUserDetails(String name) {
        this.name = name;
    }

    @Override
    public void addAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountList;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
