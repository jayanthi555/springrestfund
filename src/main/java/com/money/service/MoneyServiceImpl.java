package com.money.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.money.dao.Moneydao;
import com.money.dto.Requestaccdto;
import com.money.dto.Requestcustdto;
import com.money.dto.Responsedto;
import com.money.entity.Account;
import com.money.entity.Customer;
import com.money.exception.ExceptionById;
import com.money.exception.Exceptions;



@Service
 public class MoneyServiceImpl implements MoneyService {
    
	
	@Autowired
	Moneydao moneydao;
	
	
	@Transactional
	public Responsedto addCust(Requestcustdto requestcustdto) throws Exceptions {
		return moneydao.addCust(requestcustdto);
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		return moneydao.getAllCustomers();
	}

	@Transactional
	public Responsedto addAcc(Requestaccdto requestaccdto) throws Exception {
		
		return moneydao.addAcc(requestaccdto);
	}
    
	@Transactional
	public List<Account> getAlldetails() {
		
		return moneydao.getAlldetails();
	}
	
	@Transactional
	public Responsedto getCustById(int custid) throws ExceptionById {
		
		return moneydao.getCustById(custid);
	}
	
	
}
