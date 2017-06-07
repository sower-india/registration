package com.sower.actions;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.Action;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.UserAccess;

public class CreateUserAction implements Action 
{

	private String accessName;
	private String accessDisplayName;
	private String accessDescription;
	
	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getAccessDisplayName() {
		return accessDisplayName;
	}

	public void setAccessDisplayName(String accessDisplayName) {
		this.accessDisplayName = accessDisplayName;
	}

	public String getAccessDescription() {
		return accessDescription;
	}

	public void setAccessDescription(String accessDescription) {
		this.accessDescription = accessDescription;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String createUserAccess(){
		return "success";
	}
	
	public String populateUserAccess(){
		
		Date currentDate=Calendar.getInstance().getTime();
		
		UserAccess userAccess = new UserAccess();
		userAccess.setAccessName(getAccessName());
		userAccess.setAccessDisplayName(getAccessDisplayName());
		userAccess.setAccessDescription(getAccessDescription());
		userAccess.setCreatedDate(currentDate);
		userAccess.setUpdatedDate(currentDate);
		
		HibernateDAO.save(userAccess);
		
		return "success";
	}
}
