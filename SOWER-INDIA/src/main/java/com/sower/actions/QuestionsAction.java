package com.sower.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sower.common.constants.CommonConstants;
import com.sower.pojo.Person;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.Category;
import com.sower.rdbms.pojo.Questions;
import com.sower.rdbms.util.HibernateUtil;
import com.sower.util.DateUtil;

public class QuestionsAction extends ActionSupport implements SessionAware  
{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession;
	private String question;
	private String isRadio;
	public String getIsRadio() {
		return isRadio;
	}
	public void setIsRadio(String isRadio) {
		this.isRadio = isRadio;
	}
	private List<String> radioList;
    private String displayQuestion;
    private String description;
    private String category="GENERAL";
    
    
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getRadioList() {
		return radioList;
	}
	public void setRadioList(List<String> radioList) {
		this.radioList = radioList;
	}
	public String getDisplayQuestion() {
		return displayQuestion;
	}
	public void setDisplayQuestion(String displayQuestion) {
		this.displayQuestion = displayQuestion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public QuestionsAction()
	{
		radioList = new ArrayList<String>();
		radioList.add("YES");
		radioList.add("NO");
		
	}
	
	public String getDefaultRadioList()
	{
		return "YES";
	}
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String addFarmerQuestion() throws Exception 
	{
		return "success";
	}
	
	public String createFarmerQuestion()
	{
		Questions questions=new Questions();
		try {
		Date currentDate=DateUtil.getCurrentDate();
		Category newCategory=HibernateUtil.getCategory(getCategory());
		userSession=ActionContext.getContext().getSession();
		final long userId = ((Person)userSession.get(CommonConstants.KEY_SESSION_USER)).getUserId();
		if(newCategory==null)
		{
			newCategory=new Category();
			
			newCategory.setCategoryName(getCategory().toUpperCase());
			newCategory.setCategoryDescrption(getCategory().toUpperCase());
			newCategory.setDisplayCategoryName(getCategory().toUpperCase());
			newCategory.setCreatedDate(currentDate);
			newCategory.setUpdatedDate(currentDate);
			newCategory.setIsDeleted('N');
			newCategory.setCreatedUserId(userId);
			
				HibernateDAO.save(newCategory);
		}
		questions.setCategory(newCategory);
		questions.setDisplayQuestion(getDisplayQuestion());
		questions.setQuestionDescription(getDescription());
		questions.setIsRadio(getIsRadio().charAt(0));
		questions.setDisplaySummary('Y');
		questions.setUserType("FARMER");//Whether the question related to farmer or transport
		questions.setIsDeleted('N');
		questions.setCreatedDate(currentDate);
		questions.setUpdatedDate(currentDate);
		questions.setUserId(userId);
		HibernateDAO.save(questions);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Error adding question: "+getQuestion());
			return "failure";
		}
		return "success";
	}
	
	
	public String viewFarmerQuestions()
	{
		return "success";
	}
	
	public String viewTransportQuestions()
	{
		return "success";
	}
	
	public String viewConsumerQuestions()
	{
		return "success";
	}
	
	
	
	public String viewAddQuestion()
	{
		return "success";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession=session;
		
	}
}