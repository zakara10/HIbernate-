package com.hibernate.model;

import java.util.Date;

//POJO class
public class Employee {
	private int empId;   //POJO identity
	private String empName; //POJO Properties
	private double empSalary;
	private Date joiningDate;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, double empSalary,
			Date joiningDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.joiningDate = joiningDate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", joiningDate=" + joiningDate
				+ "]";
	}
	
	
}
