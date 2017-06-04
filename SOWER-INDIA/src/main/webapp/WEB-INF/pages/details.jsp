<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>SUCESS</title>
</head>
<body>
	<div style="text-align: center">

		<h2>Registration Successful</h2>
		<br /> <br />
		<table>
			<tr>
				<td>First Name: </td><td><s:property value="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name: </td><td><s:property value="lastName"/></td>
			</tr>
			<tr>
				<td>Email: </td><td><s:property value="email"/></td>
			</tr>
			<tr>
				<td>Phone: </td><td><s:property value="phone"/></td>
			</tr>
		</table>
	</div>
</body>
</html>

