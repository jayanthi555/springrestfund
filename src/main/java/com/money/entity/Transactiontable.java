package com.money.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAN_TBL")
public class Transactiontable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int tranid;
	
	private int frommaccno;
	private int toaccountno;
	private int amount;
	private int date;
	
	public int getTranid() {
		return tranid;
	}
	public void setTranid(int tranid) {
		this.tranid = tranid;
	}
	public int getFrommaccno() {
		return frommaccno;
	}
	public void setFrommaccno(int frommaccno) {
		this.frommaccno = frommaccno;
	}
	public int getToaccountno() {
		return toaccountno;
	}
	public void setToaccountno(int toaccountno) {
		this.toaccountno = toaccountno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Transactiontable [tranid=" + tranid + ", frommaccno="
				+ frommaccno + ", toaccountno=" + toaccountno + ", amount="
				+ amount + ", date=" + date + "]";
	}
}
