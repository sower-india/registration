package com.sower.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.sower.common.ListOptions;
import com.sower.util.RegistrationUtil;

public class HomeAction implements Action 
{
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobile;
	private String userName;
	private List<ListOptions> userAccess;
	private String selectedAccess;
	private String pwd;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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

	@Override
	public String execute() throws Exception {
		userAccess =RegistrationUtil.getUserAccessData(); 
		return "SUCCESS";
	}

	
	public List<ListOptions> getUserAccess() {
		return userAccess;
	}

	public void setUserAccess(List<ListOptions> userAccess) {
		this.userAccess = userAccess;
	}

	public String getSelectedAccess() {
		return selectedAccess;
	}

	public void setSelectedAccess(String selectedAccess) {
		this.selectedAccess = selectedAccess;
	}
	}
