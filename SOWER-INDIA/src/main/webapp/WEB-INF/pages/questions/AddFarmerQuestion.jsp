<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="form"%>
<html>
<head>
<title>SOWER-INDIA</title>
</head>
<body>
	<div style="text-align: center">
		<h2>Add Farmer Question</h2>
		<form:if test="hasActionErrors()">
			<div class="errors">
				<form:actionerror/>
			</div>
		</form:if>
		<form:if test="#session.SESSION_USER.userName != null">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <b>
			<form:property value="%{#session.SESSION_USER.userName}" />
			</b><b class="caret"></b>
			</a>
		</form:if>
		
		<form:form action="createFarmerQuestion">
		<form:textfield name="question" label="Enter Question " />
		<form:textfield name="displayQuestion" label="Enter Display Question " />
		<form:textfield name="category" label="Enter Question Category" />
		<form:textfield name="description" label="Enter Question Description" />
		<form:radio list="radioList" name="isRadio" value = "defaultRadioList" label="Show Yes/No"></form:radio>
		<form:submit value="Create Question" name="submit" />
		</form:form>
	</div>
</body>
</html>