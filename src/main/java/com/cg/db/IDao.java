package com.cg.db;

import com.cg.model.Account;

public interface IDao {

	Account getBalByNum(String num);
    Account insert(Account a);
    Account update(String num,int balanace);
    Account updatePin(Account a);
   
}
