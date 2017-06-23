<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
<head>
<link rel="stylesheet" type="text/css" href="css/sower.css">
</head>
<body>
	<div>
		<h2>Login</h2>
		<form:if test="hasActionErrors()">
			<div class="errors">
				<form:actionerror/>
			</div>
		</form:if>
		<form:form action="validateLogin" cssClass="formCSS">
			<form:textfield name="userName" label="UserName " cssClass="mytextfield" placeholder="Enter User Name"/>
			<form:password name="pwd" label="Password " cssClass="mytextfield"/>
			<form:submit cssClass="submitCSS"/>
			<a href="<form:url action="adminPage" />" class="urlCSS">View Admin Page</a>
		</form:form>
	</div>
</body>
</html>