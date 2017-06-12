package com.sower.actions;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action 
{
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
		return "success";
	}
	
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
}
