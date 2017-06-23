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
		
		<form:form action="createFarmerQuestion" cssClass="formCSS">
		<form:textfield name="question" label="Enter Question " cssClass="mytextfield"/>
		<form:textfield name="displayQuestion" label="Enter Display Question " cssClass="mytextfield"/>
		<form:textfield name="category" label="Enter Question Category" cssClass="mytextfield"/>
		<form:textfield name="description" label="Enter Question Description" cssClass="mytextfield"/>
		<form:radio list="radioList" name="isRadio" value = "defaultRadioList" label="Show Yes/No" cssClass="myradio"></form:radio>
		<form:submit value="Create Question" name="submit" cssClass="submitCSS" />
		</form:form>
	</div>
</body>
</html>