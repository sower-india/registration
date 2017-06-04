<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
<!-- 
		<form:div>Email Form</form:div>
		<form:text name="Please fill in the form below:" />
		<form:form action="hello" method="post" enctype="multipart/form-data">
			<form:hidden name="secret" value="abracadabra" />
			<form:textfield key="email.from" name="from" />
			<form:password key="email.password" name="password" />
			<form:textfield key="email.to" name="to" />
			<form:textfield key="email.subject" name="subject" />
			<form:textarea key="email.body" name="email.body" />
			<form:label for="attachment" value="Attachment" />
			<form:file name="attachment" accept="text/html,text/plain" />
			<form:token />
			<form:submit key="submit" />
		</form:form>

 -->
		<h2>User Registration</h2>
		<form:form action="register">
			<form:textfield name="firstName" label="First Name "/>
			<form:textfield name="lastName" label="Last Name " />
			<form:textfield name="email" label="Email " />
			<form:textfield name="phone" label="Phone " />
			<form:submit />
		</form:form>
	</div>
</body>
</html>