package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	public static SessionFactory obtainSessionFactory(){
		Configuration config=new Configuration().configure();
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory=config.buildSessionFactory(registry);
		return factory;
	}

}
