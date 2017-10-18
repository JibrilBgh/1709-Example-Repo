package com.revature.services;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.dto.BankUserDTO;



public class AppService {
	public BankUser validateUser(BankUser clientUser) {
		BankDao dao = new BankDaoImpl();
		
		BankUser dbUser= dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			//compare the passwords
			if( dbUser.getUsername().equals(clientUser.getUsername()) 
				&& dbUser.getPassword().equals(clientUser.getPassword())){
					return dbUser;
			}
		}
		
		return null;
	}
	
	public BankAccount getBankAccountByUsername(BankUser user) {
		return new BankDaoImpl().getBankAccountByUserId(user);
	}
	
	/*
	 * Convert Bank User & Bank Account into a BankUserDTO
	 * @param user
	 * @param bankAccount
	 * 
	 */
	
	public BankUserDTO convertToBankUserDTO(BankUser user, BankAccount bankAccount){
		
		return new BankUserDTO(user.getId(),user.getUsername(),user.getFirstName(),user.getLastName(), bankAccount.getBaId(), bankAccount.getBaBalance());
		
	} 

}
