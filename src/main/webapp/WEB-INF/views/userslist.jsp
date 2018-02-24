<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users</span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>PhoneNumber</th>
				        <th>Cell Number</th>
				         <th>Address</th>
				        
				        	<th width="100"></th>
				        
				       
				        	<th width="100"></th>
				       
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.firstName}</td>
						<td>${contact.lastName}</td>
						<td>${contact.phoneNumber}</td>
						<td>${contact.cellNumber}</td>
						<td>${contact.address}</td>
					   
							<td><a href="<c:url value='/edit-user-${contact.id}' />" class="btn btn-success custom-width">edit</a></td>
				       
							<td><a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-danger custom-width">delete</a></td>
        				
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		
		 	<div class="well">
		 		<a href="<c:url value='/newcontact' />">Add New User</a>
		 	</div>
	 	
   	</div>
</body>
</html>