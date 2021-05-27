package com.hibernate.client;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SessionFactory factory=HibernateUtil.obtainSessionFactory();
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();	//mandatory	
				

//save a new record
			Employee emp = new Employee();
			//emp.setEmpId(1039);
			emp.setEmpName("Rishi");
			emp.setEmpSalary(86000);
			emp.setJoiningDate(Date.valueOf("2010-08-03")); //format yyyy-MM-dd
			session.save(emp);
			
			Employee emp1 = new Employee();
			//emp1.setEmpId(1024);
			emp1.setEmpName("Rohan");
			emp1.setEmpSalary(99000);
			emp1.setJoiningDate(Date.valueOf("2014-05-04")); //format yyyy-MM-dd
			session.save(emp1);
			
			
			Employee emp2 = new Employee();
			//emp2.setEmpId(2345);
			emp2.setEmpName("Shiv");
			emp2.setEmpSalary(299000);
			emp2.setJoiningDate(Date.valueOf("2015-02-04")); //format yyyy-MM-dd
			session.save(emp2);
			txn.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
