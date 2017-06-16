<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
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
			<form:textfield name="city" label="City" />
			<form:textfield name="State" label="State" />
			<form:textfield name="Country" label="Country" value="INDIA"/>
			<form:textfield name="Zipcode" label="ZipCode" />
			<form:select label="UserAccess" headerKey="-1"
				headerValue="Select User Access" list="userAccess" listKey="key" listValue="value"
				name="selectedAccess" />
			<form:password name="pwd" label="Password" />
			<form:password name="rpw" label="Re-Type-Password" />
			<form:submit />
			<a href="<form:url action="login" />">login</a><br>
			<a href="<form:url action="adminPage" />">View Admin Page</a>
		</form:form>
	</div>
</body>
</html>