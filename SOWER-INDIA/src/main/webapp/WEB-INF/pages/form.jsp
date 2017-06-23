<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
<link rel="stylesheet" type="text/css" href="css/sower.css">
</head>
<body>
	<div style="text-align: center">
		<h2>User Registration</h2>
		<form:form action="register" cssClass="formRegCSS">
			<form:textfield name="firstName" label="First Name " cssClass="myRegTextfield" />
			<form:textfield name="lastName" label="SurName " cssClass="myRegTextfield" />
			<form:textfield name="emailId" label="Email " cssClass="myRegTextfield" />
			<form:textfield name="mobile" label="Mobile " cssClass="myRegTextfield" />
			<form:textfield name="userName" label="UserName" cssClass="myRegTextfield" />
			<form:textfield name="city" label="City" cssClass="myRegTextfield" />
			<form:textfield name="State" label="State" cssClass="myRegTextfield" />
			<form:textfield name="Country" label="Country" value="INDIA" cssClass="myRegTextfield" />
			<form:textfield name="Zipcode" label="ZipCode" cssClass="myRegTextfield" />
			<form:select label="UserAccess" headerKey="-1"
				headerValue="Select User Access" list="userAccess" listKey="key" listValue="value"
				name="selectedAccess" cssClass="myRegTextfield"/>
			<form:password name="pwd" label="Password" cssClass="myRegTextfield" />
			<form:password name="rpw" label="Re-Type-Password" cssClass="myRegTextfield" />
			<form:submit cssClass="submitCSS"/>
			<a href="<form:url action="login" />" class="urlCSS">login</a><br>
			<a href="<form:url action="adminPage" />" class="urlCSS">View Admin Page</a>
		</form:form>
	</div>
</body>
</html>