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
		
		<form:form action="populateCategory">
			<form:textfield name="categoryName" label="Category Name " />
			<form:textfield name="displayCategoryName" label="Display Category Name " />
			<form:textfield name="categoryDescription" label="Category Description " />
			<form:submit />
		</form:form>
	</div>
</body>
</html>