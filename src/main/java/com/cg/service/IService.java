package com.cg.service;

import com.cg.model.Account;

public interface IService {
	

	int getBalByNum(String num, String pin);
	Account insert(Account a);
	int withdraw(String num,String pin,int amount);
	void deposit(String num,String pin,int amount);
	Account updatePin(Account a);
}
