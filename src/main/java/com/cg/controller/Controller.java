package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Account;
import com.cg.service.IService;

@RestController
public class Controller {
	@Autowired
	IService service;
	
	@GetMapping("/get")
       String send()
       {
	return "This is simple banking application";
	   
       }
	@PostMapping("/post")
	Account create(@RequestBody Account a)
	{
		return service.insert(a);
		
	}
	@PutMapping("/update")
	Account updatePin(@RequestBody Account a)
	{
		return service.updatePin(a);
		
	}
	@GetMapping("/bal/{accNum}/{pin}")
	int getBalance(@PathVariable("accNum") String accNum,@PathVariable("pin") String pin)
	{
		return service.getBalByNum(accNum, pin);
	}
	@GetMapping("/withdraw/{accNum}/{pin}/{amount}")
	void withdraw(@PathVariable("accNum") String accNum,@PathVariable("pin") String pin,@PathVariable("amount") int amount)
	{
		service.withdraw(accNum, pin, amount);
	
	
      
		
		
	}
	@GetMapping("/deposit/{accNum}/{pin}/{amount}")
	void Deposit(@PathVariable("accNum") String accNum,@PathVariable("pin") String pin,@PathVariable("amount") int amount)
	{
		service.deposit(accNum, pin, amount);
	}

}
