package com.money.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACC_TBL")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accid;
	private String ifsc;

	private String branchname;
	private int custid;
	private String bank;
	private int balance;

	
	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [ifsc=" + ifsc + ", branchname=" + branchname
				+ ", custid=" + custid + ", bank=" + bank + ", balance="
				+ balance + ", accid=" + accid + "]";
	}
}
