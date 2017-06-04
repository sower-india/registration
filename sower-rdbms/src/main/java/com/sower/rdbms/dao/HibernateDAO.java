package com.sower.rdbms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sower.rdbms.util.HibernateUtil;


public class HibernateDAO<T> {
	
	public static <T> T save(T entity) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn=session.beginTransaction();
		txn.begin();
		session.save(entity);
		txn.commit();
		session.close();

		return entity;
	}
	
}