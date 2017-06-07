package com.sower.rdbms.util;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sower.rdbms.pojo.UserAccess;

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
	    
	    
	    @SuppressWarnings("unchecked")
		public static List<UserAccess> getUserAccessData()
	    {
	    	Session session = sessionFactory.openSession();
	    	

	    	String sql = "SELECT * FROM sower.user_access";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
	    	sqlQuery.addEntity(UserAccess.class);
	    	List<UserAccess> userAccessList=(List<UserAccess>)sqlQuery.list();
	    	
	    	return userAccessList;
	    	
	    }
}
