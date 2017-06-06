package com.sower.util;

import java.util.ArrayList;
import java.util.List;

import com.sower.common.ListOptions;
import com.sower.rdbms.pojo.UserAccess;
import com.sower.rdbms.util.HibernateUtil;

public class RegistrationUtil {
	
	
	public static final List<ListOptions> getUserAccessData()
	{
		
//		HibernateUtil 
		List<UserAccess> userAccessList = HibernateUtil.getUserAccessData();
		
		System.out.println(userAccessList);
		
		List<ListOptions> userAccess = new ArrayList<ListOptions>();
		
		ListOptions options = new ListOptions();
		
		options.add("1","USER");
		userAccess.add(options);
		options = new ListOptions();
		options.add("2","ADMIN");
		userAccess.add(options);
		options = new ListOptions();
		options.add("3","EMPLOYEE");
		
		userAccess.add(options);
		return userAccess;
	}

}	