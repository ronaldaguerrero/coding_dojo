<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Single Language</title>
</head>
<body>
	<form action="/delete/${lang.id}" method="post">
	   				<input type="hidden" name="_method" value="delete">
	    			<input type="submit" value="Delete">
					</form> 
					
	<a href="/languages">Dashboard</a>
	
	<form action="/update/${lang.id}" method="post">
		    <p>
		        <form:label path="name">Title</form:label>
		        <%-- <form:errors path="title"/> --%>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Description</form:label>
		        <%-- <form:errors path="description"/> --%>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Language</form:label>
		        <%-- <form:errors path="language"/> --%>
		        <form:input path="version"/>
		    </p>
		    <p>
		        <form:label path="numberOfPages">Pages</form:label>
		        <%-- <form:errors path="numberOfPages"/> --%>     
		        <form:input path="numberOfPages"/>
		    </p>    
	    <input type="submit" value="Submit"/>
	</form>
</body>
</html>