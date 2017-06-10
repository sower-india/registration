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

}	