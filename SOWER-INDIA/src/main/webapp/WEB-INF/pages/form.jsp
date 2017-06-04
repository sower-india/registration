<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>User Registration</h2>
		<form:form action="register">
			<form:textfield name="firstName" label="First Name "/>
			<form:textfield name="lastName" label="SurName " />
			<form:textfield name="emailId" label="Email " />
			<form:textfield name="mobile" label="Mobile " />
			<form:textfield name="user" label="UserName"/>
			<form:password  name="password" label = "Password"/>
			<form:password  name="password" label = "Re-Type-Password"/>
			<form:submit />
		</form:form>
	</div>
</body>
</html>