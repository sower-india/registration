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
		<form:form action="register">
			<a href="<form:url action="viewFarmerQuestions" />">Farmer Questions</a><br/>
			<a href="<form:url action="viewTransportQuestions" />">Transport Questions</a><br/>
			<a href="<form:url action="viewConsumerQuestions" />">Consumer Questions</a><br/>
			  <h1>OR</h1>
			 <a href="<form:url action="uploadQuestions" />">Upload Questions</a> 
		</form:form>
	</div>
</body>
</html>