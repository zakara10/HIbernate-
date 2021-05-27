package com.hibernate.client;

import java.sql.Date;

import org.hibernate.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Address;
import com.hibernate.model.Customer;
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
		/*
			//to save 
			Address addr=new Address();
			addr.setStreet("M G Road");
			addr.setCity("Pune");
			addr.setCountry("India");
			addr.setZip(45);
					
			Customer cust=new Customer();
			cust.setCustId(1025);
			cust.setCustName("John");		
			cust.setResAddress(addr);
			//cust.setResAddress(new Address("Karve Road", "Pune", "India", 45));
					
			session.save(cust);	*/	
			
			
			//To load data
			int cid=1025;
			Customer c=(Customer) session.get(Customer.class,cid);
			if(c!=null){
				System.out.println("Customer Id="+c.getCustId());
				System.out.println("Customer Name="+c.getCustName());
				System.out.println("Street="+c.getResAddress().getStreet());//method chaining
			//	System.out.println("Street="+c.getResAddress().getCity());
						
				Address ad=c.getResAddress();
				System.out.println("City="+ad.getCity());
				System.out.println("Country="+ad.getCountry());
				System.out.println("Zip="+ad.getZip());
				
			}
			else
			{
				System.out.println("Customer record not found!!");
			}
			
			txn.commit(); //here session is closed automatically
			System.out.println("Done!!");
		} catch (HibernateException e) {
			e.printStackTrace();
		}		


	}

}
