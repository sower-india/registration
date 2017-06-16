package com.sower.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sower.common.constants.CommonConstants;
import com.sower.pojo.Person;
import com.sower.rdbms.dao.HibernateDAO;
import com.sower.rdbms.pojo.Category;
import com.sower.rdbms.pojo.Questions;
import com.sower.rdbms.util.HibernateUtil;

public class FileUploadAction extends ActionSupport implements SessionAware 
{
		private static final long serialVersionUID = 1L;
	
		private Map<String, Object> userSession;
		private File farmerFileUpload;
		
		private File fileUpload;
		private String fileUploadContentType;
		private String fileUploadFileName;
		
		public File getFarmerFileUpload() {
			return farmerFileUpload;
		}

		public void setFarmerFileUpload(File farmerFileUpload) {
			this.farmerFileUpload = farmerFileUpload;
		}

		public String getFileUploadContentType() {
			return fileUploadContentType;
		}

		public void setFileUploadContentType(String fileUploadContentType) {
			this.fileUploadContentType = fileUploadContentType;
		}

		public String getFileUploadFileName() {
			return fileUploadFileName;
		}

		public void setFileUploadFileName(String fileUploadFileName) {
			this.fileUploadFileName = fileUploadFileName;
		}

		public File getFileUpload() {
			return fileUpload;
		}

		public void setFileUpload(File fileUpload) {
			this.fileUpload = fileUpload;
		}

		public String execute() throws Exception{

			System.out.println(fileUpload.getAbsolutePath());
			return SUCCESS;
		}

		public String display() {
			return NONE;
		}
		
		public String farmerFileUploadQuestions() throws Exception
		{
			System.out.println("File Upload is: "+farmerFileUpload);
			System.out.println("Processing File");
			
			BufferedReader reader=null;
			List<Questions> questions=null;
			Questions question=null;
			try {
				
				if(farmerFileUpload!=null)
				{
					questions=new ArrayList<Questions>();
					reader = new BufferedReader(new FileReader(farmerFileUpload));
					if(reader!=null)
					{
					String iLine=null;
					
					int i=1;
					while((iLine=reader.readLine())!=null)
					{
						if(i==1){
							i++;
							continue; //skip header
						}
						final String[] columnValues= StringUtils.splitPreserveAllTokens(iLine, CommonConstants.QUESTIONS_DATA_SEPERATOR);
						
						if(columnValues!=null)
						{
							question=populateQuestion(columnValues);
							questions.add(question);
							for (Questions q : questions) {
								HibernateDAO.save(q);
							}
						}
					}
					}
					
					} 
			}catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(reader!=null)
					{
						reader.close();
					}
				}
			return "success";
		}
		
		private Questions populateQuestion(final String[] columns) throws Exception 
		{
			Questions questions=null;

			Date currentDate=Calendar.getInstance().getTime();
			if(columns!=null)
			{
				questions = new Questions();
				Category newCategory=HibernateUtil.getCategory(columns[0]);
				userSession=ActionContext.getContext().getSession();
				final long userId = ((Person)userSession.get(CommonConstants.KEY_SESSION_USER)).getUserId();
				if(newCategory==null)
				{
					newCategory=new Category();
					
					newCategory.setCategoryName(columns[0].toUpperCase());
					newCategory.setCategoryDescrption(columns[0].toUpperCase());
					newCategory.setDisplayCategoryName(columns[0].toUpperCase());
					newCategory.setCreatedDate(currentDate);
					newCategory.setUpdatedDate(currentDate);
					newCategory.setIsDeleted('N');
					newCategory.setCreatedUserId(userId);
					HibernateDAO.save(newCategory);
				}
				questions.setCategory(newCategory);
				questions.setDisplayQuestion(columns[1]);
				questions.setQuestionDescription(columns[2]);
				questions.setIsRadio(columns[3].charAt(0));
				questions.setDisplaySummary(columns[4].charAt(0));
				questions.setUserType(columns[5]);//Whether the question related to farmer or transport
				questions.setIsDeleted('N');
				questions.setCreatedDate(currentDate);
				questions.setUpdatedDate(currentDate);
				questions.setUserId(userId);				
				
			}
			return questions;

		}

		@Override
		public void setSession(Map<String, Object> session) 
		{
			this.userSession=session;
			
		}

	}