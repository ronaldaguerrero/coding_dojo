<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<title>New License</title>
</head>
<body>
	<h1 style="text-align: center;">New License</h1>
	
	<form:form action="/create/license" method="post" modelAttribute="licenseObj" style="width:30%; margin-left:35%">
	  <div class="form-group">
	    <label>Person:</label>
        <select class="form-control" name="pObj">
			<c:forEach items="${persons}" var="person">
				<option value="${person.id}">${person.firstName} ${person.lastName}</option>
			</c:forEach>
		</select>
	  </div>
	  <div class="form-group">
	    <form:label path="state">State:</form:label>
        <form:errors path="state"/>
        <form:input path="state" class="form-control"/>
	  </div>
	  <div class="form-group">
	     <form:label path="expiration_date">Expiration Date:</form:label>
        <form:errors path="expiration_date"/>
        <form:input path="expiration_date" class="form-control" type="date"/>
	  </div>
	  <input type="submit" value="Create"/>
	</form:form>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>