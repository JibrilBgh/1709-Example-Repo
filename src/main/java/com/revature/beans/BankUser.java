package com.revature.beans;

import java.io.Serializable;

public class BankUser implements Serializable{
/**
	 * 
	 */
	
	/*
 *  U_ID
 *  U_FN
 *  U_LN
 *  U_USERNAME
 *  U_PASSWORD
 */
	private static final long serialVersionUID = -8274534882352498916L;
	
	public BankUser(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

	public BankUser(String username) {
	super();
	this.username = username;
}

	public BankUser(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public BankUser() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}
