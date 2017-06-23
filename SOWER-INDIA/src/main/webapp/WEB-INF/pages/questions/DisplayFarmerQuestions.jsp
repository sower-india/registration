<%@page import="com.sower.pojo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>Select Questions Category</h2>
		<form:if test="#session.SESSION_USER.userName != null">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <b>
			<form:property value="%{#session.SESSION_USER.userName}" />
			</b><b class="caret"></b>
			</a>
		</form:if>
		
		<form:form action="submitQuestions" namespace="/" method="POST" enctype="multipart/form-data">
		
		<form:select label="Farmer" headerKey="-1" headerValue="Select Farmer" list="userList" listKey="userId" listValue="displayName" name="selectedUser" />
		<form:property value="currentQuestion.displayQuestion"/>
		<form:hidden name="questionId" value="%{questionId}"/>
		<form:if test="%{currentQuestion.isRadio == 'Y'}">
			<form:radio list="yesNo" name="currentSolution.radioValue" value = "defaultYesNo"></form:radio>
		</form:if>
		
			<form:textfield name ="currentSolution.commentValue" label="summary" cssClass="mySummarytextfield"></form:textfield>
		
		<form:if test="%{hasMoreQuestions}">
			<form:submit name="addQuestion" value="next>>" action="questionsUpload" />
		</form:if>
			<form:submit value="submit" name="submit" cssClass="submitCSS"/>
		</form:form>
	</div>
</body>
</html>