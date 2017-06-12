package com.sower.rdbms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sower.rdbms.pojo.UserAccess;
import com.sower.rdbms.util.HibernateUtil;

public class HibernateDAO<T> {
	
	public static <T> T save(T entity) throws Exception {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
//		Transaction txn=session.beginTransaction();
//		txn.begin();
//		session.save(entity);
//		txn.commit();
//		session.close();

//		final Session session = HibernateUtil.getSession();
		try {
		  final Transaction transaction = session.beginTransaction();
		  try {
			  session.saveOrUpdate(entity);
		    transaction.commit();
		  } catch (Exception ex) {
		    // Log the exception here
		    transaction.rollback();
		    throw ex;
		  }
		} finally {
			if(session!=null)
			{
		  session.close();
			}
		}
		
		
		return entity;
	}
	
	public static UserAccess getEntityById(long id) throws Exception
	{
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UserAccess userAccess = null;
		
		try {
		  try {
			  userAccess= (UserAccess) session.get(UserAccess.class, id);
		  } catch (Exception ex) {
		    // Log the exception here
		    throw ex;
		  }
		} finally {
			if(session!=null)
			{
		  session.close();
			}
		}
		
		return userAccess;
	}
	
	
	public static boolean validateUser(final String userName,final String password)
	{
		
		return Boolean.TRUE;
	}
	
}