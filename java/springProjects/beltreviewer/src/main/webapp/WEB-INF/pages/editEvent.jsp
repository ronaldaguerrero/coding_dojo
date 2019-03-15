<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Events</title>
</head>
<body>
	<h1><c:out value="${eventObj.name}"/></h1>
	
	<h3>Edit Event</h3>
	<form:form action="/update/${eventObj.id}" method="post" modelAttribute="eventObj">
		<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="date">Date:</form:label>
		        <form:errors path="date"/>
		        <form:input path="date" type="date"/>
		    </p>
		    <p>
		        <form:label path="city">Location:</form:label>
		        <form:errors path="city"/>
		        <form:input path="city"/>
		    </p> 
		    <p>
		        <form:label path="state">State:</form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
		    </p> 
	    <input type="submit" value="Edit"/>
	</form:form>
</body>
</html>