package com.sower.actions;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sower.common.constants.CommonConstants;
import com.sower.pojo.Person;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.Category;
import com.sower.rdbms.util.HibernateUtil;

public class CategoryAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryName;
	private String displayCategoryName;
	private String categoryDescription;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDisplayCategoryName() {
		return displayCategoryName;
	}

	public void setDisplayCategoryName(String displayCategoryName) {
		this.displayCategoryName = displayCategoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}
	
	public String populateCategory() throws Exception 
	{
		
		long categoryId=HibernateUtil.validateCategory(getCategoryName());
		if(categoryId==-1)
		{
		Map<String, Object> userSession=ActionContext.getContext().getSession();
		final long userId = ((Person)userSession.get(CommonConstants.KEY_SESSION_USER)).getUserId();	
		Date currentDate=Calendar.getInstance().getTime();
		
		Category category = new Category();
		category.setCategoryName(getCategoryName());
		category.setCategoryDescrption(getCategoryDescription());
		category.setDisplayCategoryName(getDisplayCategoryName());
		category.setCreatedDate(currentDate);
		category.setUpdatedDate(currentDate);
		category.setIsDeleted('N');
		category.setCreatedUserId(userId);
		HibernateDAO.save(category);
		
		addActionMessage("Succesfully Created category: "+getCategoryName());
		}else{
			addActionMessage("Already Category : "+getCategoryName()+" exist");
		}
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
