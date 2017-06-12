<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>Login</h2>
		<form:if test="hasActionErrors()">
			<div class="errors">
				<form:actionerror/>
			</div>
		</form:if>
		<form:form action="validateLogin">
			<form:textfield name="userName" label="UserName " />
			<form:password name="pwd" label="Password " />
			<form:submit />
		</form:form>
	</div>
</body>
</html>