package com.sower.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.sower.rdbms.util.HibernateUtil;

public class LoginAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String pwd;
	
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
		boolean isValidUser=HibernateUtil.validateUser(getUserName(), getPwd());
		if(isValidUser)
		{
		return "success";
		}else{
			addActionError("User:"+getUserName()+" is invalid");
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
	
	
//	public void validate(){
//		if("mkyong".equals(getUsername())){
//			addActionMessage("You are valid user!");
//		}else{
//			addActionError("I don't know you, dont try to hack me!");
//		}
//	}
}
