package com.sower.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.sower.common.ListOptions;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.User;
import com.sower.util.DateUtil;
import com.sower.util.RegistrationUtil;

public class UserAction implements Action 
{
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobile;
	private String userName;
	private String city;
	private String state;
	private String country;
	private int zipCode;
	private List<ListOptions> userAccess=new ArrayList<ListOptions>();
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String execute() throws Exception {
		userAccess =RegistrationUtil.getUserAccessData(); 
		return "success";
	}

	public String registerUser() throws NumberFormatException, Exception
	{
		Date currentDate = DateUtil.getCurrentDate();
		User user = new User();
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		user.setEmailId(getEmailId());
		user.setMobile(Long.parseLong(getMobile()));
		user.setUserName(getUserName());
		user.setUserAccess(HibernateDAO.getEntityById(Long.parseLong(selectedAccess)));
		user.setPassword(getPwd());
		user.setCreatedDate(currentDate);
		user.setUpdatedDate(currentDate);
		
		user.setCity(getCity());
		user.setState(getState());
		user.setCountry(getCountry());
		user.setZipcode(getZipCode());
		
		//TODO change the DOB
		user.setDob(currentDate);
		
		user.setIsDeleted('N');

		HibernateDAO.save(user);
		
		System.out.println("USER ID:"+user.getUserId());
		userAccess =RegistrationUtil.getUserAccessData();
		
		return "success";
	}
	
	
	}
