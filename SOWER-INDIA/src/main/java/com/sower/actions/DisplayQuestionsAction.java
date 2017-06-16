package com.sower.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sower.pojo.Person;
import com.sower.util.RegistrationUtil;

public class DisplayQuestionsAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession;
	
	private List<Person> userList;
	private String selectedUser;
	private String userType;
	
	
	public String displayFarmerQuestion()
	{
		userList = RegistrationUtil.getUserList(getUserType());
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;

	}

	
	public List<Person> getUserList() {
		return userList;
	}

	public void setUserList(List<Person> userList) {
		this.userList = userList;
	}

	public String getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
