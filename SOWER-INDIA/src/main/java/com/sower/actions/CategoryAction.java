package com.sower.actions;
import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.Category;
import com.sower.rdbms.util.HibernateUtil;

public class CategoryAction extends ActionSupport 
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
		Date currentDate=Calendar.getInstance().getTime();
		
		Category category = new Category();
		category.setCategoryName(getCategoryName());
		category.setCategoryDescrption(getCategoryDescription());
		category.setDisplayCategoryName(getDisplayCategoryName());
		category.setCreatedDate(currentDate);
		category.setUpdatedDate(currentDate);
		category.setIsDeleted('N');
		
		HibernateDAO.save(category);
		
		addActionMessage("Succesfully Created category: "+getCategoryName());
		}else{
			addActionMessage("Already Category : "+getCategoryName()+" exist");
		}
		return "success";
	}

}
