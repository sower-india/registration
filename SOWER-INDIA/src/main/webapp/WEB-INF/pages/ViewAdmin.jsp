<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
<link rel="stylesheet" type="text/css" href="css/sower.css">
</head>
<body>
			<a href="<form:url action="login" />" class="urlCSS">Login</a><br>
			<a href="<form:url action="createUserAccess" />" class="urlCSS">Create User Access</a><br>
			<a href="<form:url action="createCategory" />" class="urlCSS">Create Category </a><br>
			<a href="<form:url action="form" />" class="urlCSS">User Registration</a><br>
</body>
</html>