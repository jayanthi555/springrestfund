package com.money.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;




import org.springframework.stereotype.Repository;







import com.money.dto.Requestaccdto;
import com.money.dto.Requestcustdto;
import com.money.dto.Responsedto;
import com.money.entity.Account;
import com.money.entity.Customer;
import com.money.exception.ExceptionById;
import com.money.exception.Exceptions;
import com.money.util.Moneyutil;


@Repository
public class MoneydaoImpl implements Moneydao{


	@Autowired
	private SessionFactory sessionFactory;

	Responsedto responsedto = new Responsedto();

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	

	public Responsedto addCust(Requestcustdto requestcustdto) throws Exceptions {
		if (null != requestcustdto) {
			Customer customer = new Customer();
			BeanUtils.copyProperties(requestcustdto, customer);
			getSession().save(customer);

			responsedto.setMessage(customer.getCustname() + Moneyutil.CUSTOMER_ADD_SUCCESS);
			responsedto.setStatusCode(HttpStatus.CREATED.value());
			return responsedto;
		} else {
			throw new Exceptions(Moneyutil.BOOK_ADDITION_FAILURE);
		}
	}


	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		List<Customer> custlist = getSession().createCriteria(Customer.class).list();
		System.out.println("customer list " + custlist);
		return custlist;
	}



	public Responsedto addAcc(Requestaccdto requestaccdto) throws Exception {
		if (null != requestaccdto) {
			Account account=new Account();
			BeanUtils.copyProperties(requestaccdto, account);
			getSession().save(account);

			responsedto.setMessage(account.getAccid() + Moneyutil.CUSTOMER_ADD_SUCCESS);
			responsedto.setStatusCode(HttpStatus.CREATED.value());
			return responsedto;
		} else {
			throw new Exceptions(Moneyutil.BOOK_ADDITION_FAILURE);
		}
			
		}



	public List<Account> getAlldetails() {
		List<Account> acclist = getSession().createCriteria(Account.class).list();
		System.out.println("account list " + acclist);
		return acclist;
	}



	public Responsedto getCustById(int custid) throws ExceptionById {
		if(custid == 0){
			throw new ExceptionById(Moneyutil.BOOK_BY_ID_FAILURE);
		}
		Account account = (Account) getSession().get(Account.class, custid);
		
		responsedto.setMessage(Moneyutil.BOOK_BY_ID + account.getAccid() + account.getIfsc() + account.getBalance() + account.getBank() + account.getBranchname());
		return responsedto;
	}

	
}

	

