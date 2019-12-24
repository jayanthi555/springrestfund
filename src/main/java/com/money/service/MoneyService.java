package com.money.service;



import java.util.List;

import com.money.dto.Requestaccdto;
import com.money.dto.Requestcustdto;
import com.money.dto.Responsedto;
import com.money.entity.Account;
import com.money.entity.Customer;
import com.money.exception.ExceptionById;
import com.money.exception.Exceptions;




public interface MoneyService {
	
	public Responsedto addCust(Requestcustdto requestcustdto) throws Exceptions;
	
	public List<Customer> getAllCustomers();
	
	public Responsedto addAcc(Requestaccdto requestaccdto) throws Exceptions, Exception;
	
	public List<Account> getAlldetails();
	
	public Responsedto getCustById(int custid) throws ExceptionById;
}
