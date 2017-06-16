package com.sower.util;

import java.util.ArrayList;
import java.util.List;

import com.sower.common.ListOptions;
import com.sower.pojo.Person;
import com.sower.rdbms.pojo.User;
import com.sower.rdbms.pojo.UserAccess;
import com.sower.rdbms.util.HibernateUtil;

public class RegistrationUtil {
	
	
	public static final List<ListOptions> getUserAccessData()
	{
		
//		HibernateUtil 
		List<UserAccess> userAccessList = HibernateUtil.getUserAccessData();
		
		List<ListOptions> userAccess =null;
		ListOptions option =null;
		if(userAccessList!=null && !userAccessList.isEmpty())
		{
			userAccess = new ArrayList<ListOptions>();
			for (UserAccess ua : userAccessList) {
				option = new ListOptions();
				option.add(String.valueOf(ua.getAccessId()), ua.getAccessDisplayName());
				userAccess.add(option);
			}
		}
		return userAccess;
	}

	public static List<Person> getUserList(final String userType) 
	{
		List<Person> persons=null;
		List<User> users = HibernateUtil.getAllUsersByAccessName(userType);
		if(users!=null && users.size()!=0)
		{
			persons=new ArrayList<Person>();
			
			Person person=null;
			for (User user : users) {
				person=new Person();
				person.setFirstName(user.getFirstName());
				person.setLastName(user.getLastName());
				person.setUserId(user.getUserId());
				person.setUserType(userType);
				person.setUserName(user.getUserName());
				persons.add(person);
			}
		}
		return persons;
	}

}	