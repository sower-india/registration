package com.sower.rdbms.util;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sower.rdbms.pojo.Category;
import com.sower.rdbms.pojo.User;
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
	    	

	    	String sql = "SELECT * FROM sower.user_access where is_deleted ='N'";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
	    	sqlQuery.addEntity(UserAccess.class);
	    	List<UserAccess> userAccessList=(List<UserAccess>)sqlQuery.list();
	    	
	    	return userAccessList;
	    	
	    }
	    
	    public static long validateUser(final String userName,final String password)
		{
	    	
	    	long userId=-1;
	    	Session session = sessionFactory.openSession();

	    	String sql = "SELECT user_id FROM sower.user  where user_name ='"+userName+"' and "+" password='"+password+"'";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
//	    	sqlQuery.addEntity(User.class);
	    	
	    	Object o=sqlQuery.uniqueResult();
	    	
	    	if(o!=null){
	    		
	    		userId = ((BigInteger)o).longValue();
	    		System.out.println("i===="+userId);
	    	}
	    	
	    	return userId;
	    	
	    }
	    
	    public static long validateCategory(final String categoryName)
		{
	    	
	    	long categoryId=-1;
	    	Session session = sessionFactory.openSession();

	    	String sql = "SELECT category_id FROM sower.category  where category_name ='"+categoryName+"'";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
//	    	sqlQuery.addEntity(User.class);
	    	
	    	Object o=sqlQuery.uniqueResult();
	    	
	    	if(o!=null){
	    		
	    		categoryId = ((BigInteger)o).longValue();
	    		System.out.println("i===="+categoryId);
	    	}
	    	
	    	return categoryId;
	    	
	    }
	    
	    public static long validateQuestion(final String displayQuestion)
		{
	    	
	    	long questionId=-1;
	    	Session session = sessionFactory.openSession();

	    	String sql = "SELECT QUESTION_ID FROM sower.questions  where category_name ='"+displayQuestion+"'";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
//	    	sqlQuery.addEntity(User.class);
	    	
	    	Object o=sqlQuery.uniqueResult();
	    	
	    	if(o!=null){
	    		
	    		questionId = ((BigInteger)o).longValue();
	    		System.out.println("i===="+questionId);
	    	}
	    	
	    	return questionId;
	    	
	    }
	    
	    public static Category getCategory(final String categoryName)
	  		{
	  	    	
	  	    	Category category=null;
	  	    	Session session = sessionFactory.openSession();

	  	    	String sql = "SELECT * FROM sower.category  where category_name ='"+categoryName.toUpperCase()+"'";
	  	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
	  	    	sqlQuery.addEntity(Category.class);
	  	    	
	  	    	Object o=sqlQuery.uniqueResult();
	  	    	
	  	    	if(o!=null){
	  	    		
	  	    		category = (Category)o;
	  	    		System.out.println("i===="+category);
	  	    	}
	  	    	
	  	    	return category;
	  	    }  
	    
	    public static User getUserById(final long categoryName)
  		{
  	    	
  	    	User user=null;
  	    	Session session = sessionFactory.openSession();

  	    	String sql = "SELECT * FROM sower.user  where user_Id ="+categoryName;
  	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
  	    	sqlQuery.addEntity(User.class);
  	    	
  	    	Object o=sqlQuery.uniqueResult();
  	    	
  	    	if(o!=null){
  	    		
  	    		user = (User)o;
  	    		System.out.println("i===="+user);
  	    	}
  	    	
  	    	return user;
  	    }
	    
	    public static User getEntityById(long id) throws Exception
		{
	    	
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			User user = null;
			
			try {
			  try {
				  user= (User) session.get(User.class, id);
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
			
			return user;
		}
	    
	    @SuppressWarnings("unchecked")
	    public static List<User> getAllUsersByAccessName(final String accessType)
	    {
	    	Session session = sessionFactory.openSession();

	    	String sql = "select * from user u join user_access ua on u.access_id=ua.access_id where access_name = '"+accessType+"';";
	    	SQLQuery sqlQuery = session.createSQLQuery(sql);
	    	sqlQuery.addEntity(User.class);
	    	
			List<User> users=(List<User>)sqlQuery.list();
	    	
	    	return users;
	    	
	    }
}
