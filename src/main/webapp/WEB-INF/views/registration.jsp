<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

 	<div class="generic-container">
	<div class="well lead">User Registration Form</div>
 	<form:form method="POST" modelAttribute="contact" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="phoneNumber">phoneNumber</label>
				<div class="col-md-7">
					<c:choose>
						<c:when test="${edit}">
							<form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control 

input-sm" disabled="true"/>
						</c:when>
						<c:otherwise>
							<form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control 

input-sm" />
							<div class="has-error">
								<form:errors path="phoneNumber" class="help-inline"/>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="password">cellNumber</label>
				<div class="col-md-7">
					<form:input type="text" path="cellNumber" id="cellNumber" class="form-control input-sm" 

/>
					<div class="has-error">
						<form:errors path="cellNumber" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address">address</label>
				<div class="col-md-7">
					<form:input type="text" path="address" id="address" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="address" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a 

href="<c:url value='/contacts' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a 

href="<c:url value='/contacts' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>