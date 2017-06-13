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
		
		<form:form action="">
			<a href="<form:url action="viewFarmerQuestions" />">Farmer Questions</a><br/>
			<a href="<form:url action="viewTransportQuestions" />">Transport Questions</a><br/>
			<a href="<form:url action="viewConsumerQuestions" />">Consumer Questions</a><br/>
		</form:form>
	</div>
</body>
</html>