package com.revature.dao;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;


public interface BankDao {
	//Create
	
	//Read
	public BankUser getUserByUsername(BankUser user);
	public BankAccount getBankAccountByUserId(BankUser user);
	//Update
	
	//Delete
}
