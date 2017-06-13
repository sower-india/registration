<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>User Access Creation</h2>
		<form:form action="populateUserAccess">
			<form:textfield name="accessName" label="Access Name " />
			<form:textfield name="accessDisplayName" label="Access DisplayName " />
			<form:textfield name="accessDescription" label="Access Description " />
			<form:submit />
			<a href="<form:url action="adminPage" />">View Admin Page</a>
		</form:form>
	</div>
</body>
</html>