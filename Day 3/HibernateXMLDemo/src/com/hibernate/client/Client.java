package com.hibernate.client;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Configuration config=new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory=config.buildSessionFactory(registry);
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();	//mandatory	
				
		
		//save a new record
			/*Employee emp = new Employee();
			emp.setEmpId(1039);
			emp.setEmpName("Rishi");
			emp.setEmpSalary(86000);
			emp.setJoiningDate(Date.valueOf("2010-08-03")); //format yyyy-MM-dd
			session.save(emp);
			
			Employee emp1 = new Employee();
			emp1.setEmpId(1024);
			emp1.setEmpName("Rohan");
			emp1.setEmpSalary(99000);
			emp1.setJoiningDate(Date.valueOf("2014-05-04")); //format yyyy-MM-dd
			session.save(emp1);
			*/
			
		/*	Employee emp2 = new Employee();
			emp2.setEmpId(2345);
			emp2.setEmpName("Shiv");
			emp2.setEmpSalary(299000);
			emp2.setJoiningDate(Date.valueOf("2015-02-04")); //format yyyy-MM-dd
			session.save(emp2);*/
			
			
			//To load the data
			/*load throws Exception if Record not found 
			 * get returns null if Record not found 
			 */
		
			/*Scanner sc=new Scanner(System.in);
			System.out.println("Enter Emp Id to be searched=");
			int eid=sc.nextInt();
			Employee emp=(Employee) session.get(Employee.class, eid);
			if(emp!=null){
				System.out.println("Employee Id="+emp.getEmpId());
				System.out.println("Employee Name="+emp.getEmpName());
				System.out.println("Employee Salary="+emp.getEmpSalary());
				System.out.println("Joining Date="+emp.getJoiningDate());
			}
			else{
				System.out.println("Record not found!!");
			}
			*/
			
			//update
			/*Scanner sc=new Scanner(System.in);
			System.out.println("Enter Emp Id=");
			int eid=sc.nextInt();
			System.out.println("Enter New Salary=");
			double sal=sc.nextDouble();
			
			Employee e=(Employee) session.get(Employee.class, eid);
			if(e!=null)
			{
				e.setEmpSalary(sal);			
				session.update(e);
				System.out.println("Record updated");
			}
			else{
				System.out.println("Record not found!!");
			}*/
				
			
			//delete
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Emp Id to be deleted=");
			int eid=sc.nextInt();
			Employee e=(Employee) session.get(Employee.class, eid);
			if(e!=null){
				session.delete(e);
				System.out.println("Record deleted!!");
			}
			else{
				System.out.println("Record not found!!");
			}
			
			txn.commit(); //here session is closed automatically
			System.out.println("Done!!");
		} catch (HibernateException e) {
			e.printStackTrace();
		}		


	}

}
