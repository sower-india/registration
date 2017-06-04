package com.sower.rdbms.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

	public class HibernateUtil {
	 
	    private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	        	Configuration configuration = new Configuration();
	            configuration.configure();
	            StandardServiceRegistry registry=new StandardServiceRegistryBuilder()
	            .applySettings(configuration.getProperties())
	            .build();
	            return configuration.buildSessionFactory(registry);
	                
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
