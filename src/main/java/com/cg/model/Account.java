package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Account {
	@Id
	 private String accNum;
	 private String accType;
	 private String name;
	  private int amount;
	   private int balance;
	   private String pin;
	   public Account()
	   {}

	 public String getPin() {
		return pin;
	 }
	 public void setPin(String pin) {
		this.pin = pin;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", accType=" + accType + ", accNum=" + accNum + ", amount=" + amount + ", balance="
				+ balance + ", pin=" + pin + "]";
	}


}
