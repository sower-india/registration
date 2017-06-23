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
		<h2>View Farmer Questions</h2>
		<form:if test="#session.SESSION_USER.userName != null">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <b>
			<form:property value="%{#session.SESSION_USER.userName}" />
			</b><b class="caret"></b>
			</a>
		</form:if>
		
		<form:form action="farmerFileUploadQuestions" namespace="/" method="POST" enctype="multipart/form-data">
		<form:url action="displayFarmerQuestion" var="urlTag">
		<form:param name="userType">FARMER</form:param>
		</form:url>
			<a href="<form:property value="#urlTag" />" >View Farmer Questions</a> <br/>
			<b>OR</b> <br/>
			<a href="<form:url action="addFarmerQuestion" />">Add Farmer Question</a> <br />
			<b>OR</b><br/>
			<form:file name="farmerFileUpload" label="Select former File to upload" size="40" /> <br />
			<form:submit value="submit" name="submit" />
		</form:form>
	</div>
</body>
</html>