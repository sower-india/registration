package com.sower.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sower.pojo.Person;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.Questions;
import com.sower.rdbms.pojo.Solutions;
import com.sower.util.RegistrationUtil;

public class DisplayQuestionsAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession;
	
	private List<Person> userList;
	private String selectedUser;
	private String userType;
	private List<String> yesNo = new ArrayList<String>();
	private String inputYesNo;

	private long questionId=0;
	private String displayQuestion;
	List<Solutions> populatedSolutions = new ArrayList<Solutions>();
	private Solutions currentSolution;
	private boolean hasMoreQuestions;
	List<Questions> questions = new ArrayList<Questions>();
	private Questions currentQuestion;
	
	
	@SuppressWarnings("unchecked")
	public String submitQuestions() 
	{
		
		try{
			populatedSolutions = (List<Solutions>) userSession.get("POPULATED_LIST");
			if(populatedSolutions!=null && !populatedSolutions.isEmpty())
			{
		for (Solutions solution : populatedSolutions) {
			HibernateDAO.save(solution);
		}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String questionsUpload()
	{
		 currentSolution.setQuestionerId(getQuestionId());

		 userSession = ActionContext.getContext().getSession();
		 populatedSolutions = (List<Solutions>) userSession.get("POPULATED_LIST");
		 if(populatedSolutions==null)
		 {
			 userSession.put("POPULATED_LIST",new ArrayList<Solutions>());
		 }
		 
		if(currentSolution!=null)
		{
			populatedSolutions.add(currentSolution);
			userSession.put("POPULATED_LIST",populatedSolutions);
		}
		setSelectedUser(selectedUser);
		
		return displayFarmerQuestion();
	}
	@SuppressWarnings("unchecked")
	public String displayFarmerQuestion()
	{
		userSession = ActionContext.getContext().getSession(); 
		questions=(List<Questions>) userSession.get("QUESTION_LIST");
		if(questions==null)
		{
		questions = RegistrationUtil.getQuestions(getUserType());
		userSession.put("QUESTION_LIST", questions);
		}
		
		Iterator<Questions> iterator=questions.iterator();
		hasMoreQuestions = iterator.hasNext();
		userSession.put("HAS_MORE_QUESTIONS", hasMoreQuestions);
		
		if(hasMoreQuestions)
		{
			yesNo=new ArrayList<String>();
			
			yesNo.add("YES");
			yesNo.add("NO");
			
		currentQuestion=iterator.next();
		iterator.remove();
		userType=currentQuestion.getUserType();
		displayQuestion=currentQuestion.getDisplayQuestion();
		questionId=currentQuestion.getQuestionId();
		}
		userList=(List<Person>) userSession.get("USER_LIST_"+getUserType());
		
		if(userList==null)
		{
		userList = RegistrationUtil.getUserList(getUserType());
		userSession.put("USER_LIST_"+getUserType(), userList);
		}
		
		return "success";
	}

	public String getDefaultYesNo()
	{
		return "YES";
	}
	public List<String> getYesNo() {
		return this.yesNo;
	}

	public void setYesNo(List<String> yesNo) {
		this.yesNo = yesNo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}

	
	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public Questions getCurrentQuestion() {
		return this.currentQuestion;
	}

	public void setCurrentQuestion(Questions currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public List<Solutions> getPopulatedSolutions() {
		return populatedSolutions;
	}

	public void setPopulatedSolutions(List<Solutions> populatedSolutions) {
		this.populatedSolutions = populatedSolutions;
	}

	public Solutions getCurrentSolution() {
		return currentSolution;
	}

	public void setCurrentSolution(Solutions currentSolution) {
		this.currentSolution = currentSolution;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getDisplayQuestion() {
		return displayQuestion;
	}

	public void setDisplayQuestion(String displayQuestion) {
		this.displayQuestion = displayQuestion;
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
	
	public boolean isHasMoreQuestions() {
		return hasMoreQuestions;
	}

	public void setHasMoreQuestions(boolean hasMoreQuestions) {
		this.hasMoreQuestions = hasMoreQuestions;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public String getInputYesNo() {
		return inputYesNo;
	}

	public void setInputYesNo(String inputYesNo) {
		this.inputYesNo = inputYesNo;
	}
}
