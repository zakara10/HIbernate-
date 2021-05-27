package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue( value = "pemp")
public class PermanentEmployee extends Employee 
{

	@Column(length=20)
	private String department;
	@Column(length=20)
	private String designation;
	
	
	public PermanentEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PermanentEmployee(String department, String designation) {
		super();
		this.department = department;
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "PermanentEmployee [department=" + department + ", designation="
				+ designation + "]";
	}
	
	
	
}
