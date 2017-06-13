package com.sower.rdbms.pojo;

// default package
// Generated 4 Jun, 2017 4:15:39 PM by Hibernate Tools 4.0.0

import java.util.Date;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private UserAccess userAccess;
	private String firstName;
	private String lastName;
	private String emailId;
	private long mobile;
	private Date dob;
	private String userName;
	private String password;
	private Date createdDate;
	private Date updatedDate;
	private char isDeleted;
	private Long createdUserId;
	

	public User() {
	}

	public User(UserAccess userAccess, String firstName, String lastName,
			long mobile, Date dob, String userName, String password,
			Date createdDate, Date updatedDate, char isDeleted, long createdUserId) {
		this.userAccess = userAccess;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
		this.createdUserId=createdUserId;
	}

	public User(UserAccess userAccess, String firstName, String lastName,
			String emailId, long mobile, Date dob, String userName,
			String password, Date createdDate, Date updatedDate, char isDeleted, Long createdUserId) {
		this.userAccess = userAccess;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobile = mobile;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
		this.createdUserId=createdUserId;
	}
	
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserAccess getUserAccess() {
		return this.userAccess;
	}

	public void setUserAccess(UserAccess userAccess) {
		this.userAccess = userAccess;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobile() {
		return this.mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public char getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(char isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
	}

	
}
