package com.hibernate.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Book;
import com.hibernate.util.HibernateUtil;

public class Client_Select {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SessionFactory factory=HibernateUtil.obtainSessionFactory();
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();	//mandatory	
			
			//print all the book titles & authors
			/*Query q=session.createQuery("select b.title,b.author from Book b");
			List lst=q.list();
			Iterator itr=lst.iterator();
			while(itr.hasNext()){
				Object[] obj=(Object[]) itr.next();
				System.out.println(obj[0]+"--"+obj[1]);
			}		
			*/
						
			//print all book title & price in a particular range
			/*double min=1000;
			double max=2000;		
			
			Query q=session.createQuery("select b.title,b.price from Book b where b.price between ? and ?");
			q.setParameter(0, min);
			q.setParameter(1, max);
			List lst=q.list();
			Iterator itr=lst.iterator();
			while(itr.hasNext()){
				Object[] obj=(Object[]) itr.next();
				System.out.println(obj[0]+"--"+obj[1]);
			}*/
			
			
			//print total no of books,cheapest price,expensive price
			Query q=session.createQuery("select count(*),min(b.price),max(b.price) from Book b");
			List lst=q.list();
			Iterator itr=lst.iterator();
			while(itr.hasNext()){
				Object[] obj=(Object[]) itr.next();
				System.out.println("Total No of Books="+obj[0]);
				System.out.println("cheapest price="+obj[1]);
				System.out.println("expensive price="+obj[2]);
			}
			
			
			txn.commit(); //here session is closed automatically
			System.out.println("Done!!");
		} catch (HibernateException e) {
			e.printStackTrace();
		}		


	}

}










