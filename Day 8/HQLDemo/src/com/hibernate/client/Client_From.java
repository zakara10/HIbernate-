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

public class Client_From {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SessionFactory factory=HibernateUtil.obtainSessionFactory();
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();	//mandatory	
			
			//save
			/*Book b1=new Book("Let Us C","YK",879);
			Book b2=new Book("Complete Reference C++","HS",1200);
			Book b3=new Book("Thinking in Java","KS",1500);
			Book b4=new Book("Inside Android","GT",1267);
			Book b5=new Book("Python Programming","MP",2500);
			
			session.save(b1);
			session.save(b2);
			session.save(b3);
			session.save(b4);
			session.save(b5);*/
			
			
			//select all records
			/*Query q=session.createQuery("from Book b");
			List<Book> lst=q.list();
			Iterator<Book> itr=lst.iterator();
			while(itr.hasNext()){
				Book bk=itr.next();
				System.out.println(bk);
			}*/
					

			//passing runtime parameter to HQL
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter minimum price");
			double min=sc.nextDouble();
			System.out.println("Enter maximum price");
			double max=sc.nextDouble();
			
			//1)using positional parameter (?) starts from zero
			/*Query q=session.createQuery("from Book b where b.price between ? and ?");
			q.setParameter(0, min);
			q.setParameter(1, max);*/
			
			
			//2)using named parameter (:) 
			Query q=session.createQuery("from Book b where b.price between :p1 and :p2");
			q.setParameter("p1", min);
			q.setParameter("p2", max);
			
			List<Book> lst=q.list();
			Iterator<Book> itr=lst.iterator();
			while(itr.hasNext()){
				Book bk=itr.next();
				System.out.println(bk);
			}
						
			txn.commit(); //here session is closed automatically
			System.out.println("Done!!");
		} catch (HibernateException e) {
			e.printStackTrace();
		}		


	}

}










