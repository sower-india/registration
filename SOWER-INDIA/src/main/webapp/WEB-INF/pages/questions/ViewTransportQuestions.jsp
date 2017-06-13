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
		
		<form:form action="transportFileUploadQuestions" namespace="/" method="POST" enctype="multipart/form-data">
			<a href="<form:url action="displayTransportQuestion" />">Transport Questions</a>
			<h1>OR</h1>
			<a href="<form:url action="addTransportQuestion" />">Add Transport Question</a> <br />
			<h1>OR</h1>
			<form:file name="TransportFileUpload" label="Select Transport File to upload" size="40" /> <br />
			<form:submit value="submit" name="submit" />
		</form:form>
	</div>
</body>
</html>