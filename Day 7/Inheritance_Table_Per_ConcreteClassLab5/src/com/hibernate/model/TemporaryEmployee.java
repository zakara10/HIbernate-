package com.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tempin2")
@AttributeOverrides({
	@AttributeOverride(column = @Column(name="name_t",length=20), name = "name"),
	@AttributeOverride(column = @Column(name="sal_t"), name = "salary")
	})
public class TemporaryEmployee extends Employee {

	@Column(length=20)
	private String contractorname;
	
	private int workingdays;
	
	
	public TemporaryEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TemporaryEmployee(int id, String name, double salary) {
		super(id, name, salary);
		// TODO Auto-generated constructor stub
	}
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
