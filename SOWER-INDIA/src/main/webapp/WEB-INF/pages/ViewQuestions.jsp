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
		<form:form action="fileUploadQuestions" namespace="/"  method="POST" enctype="multipart/form-data">
			<a href="<form:url action="viewFarmerQuestions" />">Farmer Questions</a><br/>
			<a href="<form:url action="viewTransportQuestions" />">Transport Questions</a><br/>
			<a href="<form:url action="viewConsumerQuestions" />">Consumer Questions</a><br/>
			  <h1>OR</h1>
			 <form:file name="fileUpload" label="Select a File to upload" size="40" />
			  <h1>OR</h1>
			 <a href="<form:url action="AddQuestion" />">Add Question</a><br/>
			 
			<form:submit value="submit" name="submit" /> 
		</form:form>
	</div>
</body>
</html>