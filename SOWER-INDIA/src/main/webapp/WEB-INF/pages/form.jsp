<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<!-- 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
 -->

<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>User Registration</h2>
		<form:form action="register">
			<form:textfield name="firstName" label="First Name " />
			<form:textfield name="lastName" label="SurName " />
			<form:textfield name="emailId" label="Email " />
			<form:textfield name="mobile" label="Mobile " />
			<form:textfield name="userName" label="UserName" />
			<form:select label="UserAccess" headerKey="-1"
				headerValue="Select User Access" list="userAccess" listKey="key" listValue="value"
				name="selectedAccess" />
			<form:password name="pwd" label="Password" />
			<form:password name="rpw" label="Re-Type-Password" />
			<form:submit />
			<form:url action ="login" />
			
		</form:form>
	</div>
</body>
</html>