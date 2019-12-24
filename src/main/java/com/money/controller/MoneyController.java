package com.money.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;














import com.money.entity.Account;
import com.money.entity.Customer;
import com.money.exception.ExceptionById;
import com.money.exception.Exceptions;
import com.money.dto.Requestaccdto;
import com.money.dto.Requestcustdto;
import com.money.dto.Responsedto;
import com.money.service.MoneyService;

@RestController
@RequestMapping("/money")
public class MoneyController {

	@Autowired
	MoneyService moneyservice;

	@RequestMapping(value = "/addCust", method = RequestMethod.POST)
	public ResponseEntity<Responsedto> addBooks(Requestcustdto requestcustdto) throws Exceptions {
		return new ResponseEntity<Responsedto>(moneyservice.addCust(requestcustdto), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(moneyservice.getAllCustomers(),HttpStatus.OK);
		
	}
	@RequestMapping(value="/addAcc", method=RequestMethod.POST)
	public ResponseEntity<Responsedto> addAcc(Requestaccdto requestaccdto) throws Exception {
		return new ResponseEntity<Responsedto>(moneyservice.addAcc(requestaccdto), HttpStatus.CREATED);
	}
	@RequestMapping(value="/getAlldetails", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getMessagee() {
		return new ResponseEntity<List<Account>>(moneyservice.getAlldetails(),HttpStatus.OK);
	}
	@RequestMapping(value= "/getCustById/{custid}",method = RequestMethod.GET)
	public ResponseEntity<Responsedto> getCustById(int custid) throws ExceptionById {
		return new ResponseEntity<Responsedto>(moneyservice.getCustById(custid),HttpStatus.OK);
	}
	
	
	
}

