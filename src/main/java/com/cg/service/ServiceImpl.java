package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.db.IDao;
import com.cg.exception.UserException;
import com.cg.model.Account;

@Service
public class ServiceImpl implements IService{
    @Autowired
    IDao db;
    Account a=new Account();
	@Override
	public int getBalByNum(String num,String pin) {
		a=db.getBalByNum(num);
		String pin1=a.getPin();
		if(pin.equals(pin1))
			return a.getBalance();
		else
		    return 0;
	}

	@Override
	public Account insert(Account a) {
		return db.insert(a);
		
	}

	@Override
	public int withdraw(String num, String pin, int amount) {
		int flag=0;
		a=db.getBalByNum(num);
		String pin1=a.getPin();
		int balance=a.getBalance();
		if(pin.equals(pin1))
		{
			if(!(amount>balance))
			{
				balance=balance-amount;
				a=db.update(num, balance);
				flag=1;
			}
			
		}
		else
		{
			try
			{
			throw new UserException("Pin is not valid!!");
			}
			catch(UserException e)
			{
				System.out.println(e);
			}
		}
		return flag;
	}

	@Override
	public void deposit(String num, String pin, int amount) {
		a=db.getBalByNum(num);
		String pin1=a.getPin();
		int balance=a.getBalance();
		if(pin.equals(pin1))
		{
			
				balance=balance+amount;
				a=db.update(num, balance);
		}
		
	}

	@Override
	public Account updatePin(Account a) {
		
		return db.updatePin(a);
	}

	

}
