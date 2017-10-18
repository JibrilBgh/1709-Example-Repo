package com.revature.dto;

import com.revature.beans.BankUser;

/*
 * Combine all the User info to transfer 
 *  this can be more or less than 
 *  in this case we added more like BankAccount information
 */

public class BankUserDTO extends BankUser{
	private int baId;
	private double baBalance;
	
	public BankUserDTO() {}

	public BankUserDTO(String username, String password, int baId, double baBalance) {
		super(username, password);
		this.baId = baId;
		this.baBalance = baBalance;
	}

	public BankUserDTO(int id, String username, String firstName, String lastName, int baId, double baBalance) 
	{
		super(id, username,firstName, lastName, null);
		this.baId = baId;
		this.baBalance = baBalance;
	}
	

	public int getBaId() {
		return baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	public double getBaBalance() {
		return baBalance;
	}

	public void setBaBalance(double baBalance) {
		this.baBalance = baBalance;
	}

	@Override
	public String toString() {
		return "BankUserDTO [baId=" + baId + ", baBalance=" + baBalance + ", getBaId()=" + getBaId()
				+ ", getBaBalance()=" + getBaBalance() + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
	

}
