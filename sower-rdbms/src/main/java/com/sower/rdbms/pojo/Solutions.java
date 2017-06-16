package com.sower.rdbms.pojo;
// default package
// Generated 15 Jun, 2017 8:22:38 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Solutions generated by hbm2java
 */
public class Solutions implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long soultionId;
	private Questions questions;
	private long questionerId;
	private long userId;
	private Character radioValue;
	private String commentValue;
	private Date createdDate;
	private Date updatedDate;
	private char isDeleted;

	public Solutions() {
	}

	public Solutions(Questions questions, long questionerId, long userId,
			Date createdDate, Date updatedDate, char isDeleted) {
		this.questions = questions;
		this.questionerId = questionerId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
	}

	public Solutions(Questions questions, long questionerId, long userId,
			Character radioValue, String commentValue, Date createdDate,
			Date updatedDate, char isDeleted) {
		this.questions = questions;
		this.questionerId = questionerId;
		this.userId = userId;
		this.radioValue = radioValue;
		this.commentValue = commentValue;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
	}

	public Long getSoultionId() {
		return this.soultionId;
	}

	public void setSoultionId(Long soultionId) {
		this.soultionId = soultionId;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public long getQuestionerId() {
		return this.questionerId;
	}

	public void setQuestionerId(long questionerId) {
		this.questionerId = questionerId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Character getRadioValue() {
		return this.radioValue;
	}

	public void setRadioValue(Character radioValue) {
		this.radioValue = radioValue;
	}

	public String getCommentValue() {
		return this.commentValue;
	}

	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
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
}
