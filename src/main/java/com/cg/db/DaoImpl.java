package com.cg.db;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.Account;

@Repository
public class DaoImpl implements IDao{
	@Autowired
	private MongoTemplate mongoTemplate;

	public Account getBalByNum(String accNum) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accNum").is(accNum));
		return mongoTemplate.findOne(query, Account.class);
	}

	@Override
	public Account insert(Account a) {
		Random random = new Random();
		String pin = String.format("%04d", random.nextInt(10000));
		a.setPin(pin);
		mongoTemplate.save(a);
		return a;
		
	}

	@Override
	public Account update(String accNum, int balance) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accNum").is(accNum));
		Account acc=mongoTemplate.findOne(query, Account.class);
		acc.setBalance(balance);
		mongoTemplate.save(acc);
		return mongoTemplate.findOne(query, Account.class);
	}

	@Override
	public Account updatePin(Account a) {
		Query query = new Query();
		query.addCriteria(Criteria.where("accNum").is(a.getAccNum()));
		Account acc=mongoTemplate.findOne(query, Account.class);
		acc.setPin(a.getPin());
		mongoTemplate.save(acc);
		return mongoTemplate.findOne(query, Account.class);
	}
}
