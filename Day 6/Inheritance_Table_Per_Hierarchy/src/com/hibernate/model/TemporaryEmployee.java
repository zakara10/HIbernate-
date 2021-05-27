package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue( value = "temp")
public class TemporaryEmployee extends Employee {

	@Column(length=20)
	private String contractorname;
	
	@Column
	private int workingdays;
	
	
	public String getContractorname() {
		return contractorname;
	}
	public void setContractorname(String contractorname) {
		this.contractorname = contractorname;
	}
	public int getWorkingdays() {
		return workingdays;
	}
	public void setWorkingdays(int workingdays) {
		this.workingdays = workingdays;
	}
	@Override
	public String toString() {
		return "TemporaryEmployee [contractorname=" + contractorname
				+ ", workingdays=" + workingdays + "]";
	}
	
	
}
