package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibcust")
public class Customer {
	
	@Id
	@Column(name="cid")
	private int custId;
	
	@Column(name="cname",length=20)
	private String custName;
	
	@Embedded
	private Address resAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String custName, Address resAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.resAddress = resAddress;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Address getResAddress() {
		return resAddress;
	}
	public void setResAddress(Address resAddress) {
		this.resAddress = resAddress;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", resAddress=" + resAddress + "]";
	}
	
	
}
