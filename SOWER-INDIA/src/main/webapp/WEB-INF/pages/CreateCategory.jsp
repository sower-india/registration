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
		
		<form:if test="hasActionErrors()">
			<div class="errors">
				<form:actionerror/>
			</div>
		</form:if>
		
		<form:if test="hasActionMessages()">
			<div class="msgs">
				<form:actionmessage/>
			</div>
		</form:if>
		
		<form:form action="populateCategory">
			<form:textfield name="categoryName" label="Category Name " cssClass="mytextfield"/>
			<form:textfield name="displayCategoryName" label="Display Category Name " cssClass="mytextfield"/>
			<form:textfield name="categoryDescription" label="Category Description " cssClass="mytextfield"/>
			<form:submit cssClass="submitCSS"/>
			<a href="<form:url action="adminPage" />" css="urlCSS">View Admin Page</a>
		</form:form>
	</div>
</body>
</html>