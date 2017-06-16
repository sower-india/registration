package com.sower.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sower.common.constants.CommonConstants;
import com.sower.pojo.Person;
import com.sower.rdbms.util.HibernateUtil;

public class LoginAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String pwd;
	
	private Person user;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String validateLogin() 
	{
		long userId=HibernateUtil.validateUser(getUserName(), getPwd());
		if(userId!=-1)
		{
			user=new Person();
			user.setUserName(userName);
			user.setUserId(userId);
			userSession.put(CommonConstants.KEY_SESSION_USER, user);
		return "success";
		}else{
			addActionError("User: "+getUserName()+ " is invalid");
			return "failure";
		}
	}
	
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	private Map<String, Object> userSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		
		this.userSession=session;
	}

	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	
}
