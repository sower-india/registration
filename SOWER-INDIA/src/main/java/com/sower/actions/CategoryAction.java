package com.sower.actions;
import com.opensymphony.xwork2.Action;

public class CategoryAction implements Action 
{
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public String populateCategory() 
	{
//Date currentDate=Calendar.getInstance().getTime();
		
//		UserAccess userAccess = new UserAccess();
//		userAccess.setAccessName(getAccessName());
//		userAccess.setAccessDisplayName(getAccessDisplayName().toUpperCase());
//		userAccess.setAccessDescription(getAccessDescription());
//		userAccess.setCreatedDate(currentDate);
//		userAccess.setUpdatedDate(currentDate);
//		userAccess.setIsDeleted('N');
//		HibernateDAO.save(userAccess);
		
		return "success";
	}

}
