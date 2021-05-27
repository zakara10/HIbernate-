package com.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Employee;
import com.hibernate.model.PermanentEmployee;
import com.hibernate.model.TemporaryEmployee;


public class HibernateMain {

	public static void main(String[] args) {

	   

		Configuration config = new Configuration().configure();
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction(); // mandatory

		
		 /*PermanentEmployee pemp1 = new PermanentEmployee();
			pemp1.setId(123);
			pemp1.setName("Anup");
			pemp1.setSalary(50000);
			pemp1.setDepartment("Hr");
			pemp1.setDesignation("Sr. Hr Executive");

			TemporaryEmployee temp1 = new TemporaryEmployee();
			temp1.setId(305);
			temp1.setName("Shreyash");
			temp1.setSalary(70000);
			temp1.setContractorname("Sarang");
			temp1.setWorkingdays(20);
		//To save
		session.save(pemp1);
		session.save(temp1);*/
		

		//To load
		int eid=123;
		Employee e=(Employee) session.get(Employee.class, eid);
		if(e!=null){
			System.out.println("Employee Id="+e.getId());
			System.out.println("Employee Name="+e.getName());
			System.out.println("Employee Salary="+e.getSalary());
						
			if(e instanceof PermanentEmployee){
				PermanentEmployee pe= (PermanentEmployee) e;
				System.out.println("Designation="+pe.getDesignation());
				System.out.println("Department="+pe.getDepartment());
			}
			if(e instanceof TemporaryEmployee){
				TemporaryEmployee te=(TemporaryEmployee) e;
				System.out.println("Working Days="+te.getWorkingdays());
				System.out.println("Contractor Name="+te.getContractorname());
			}
		}
		else{
			System.out.println("Employee record not found!!");
		}
	
		 
		txn.commit();

	}

}
