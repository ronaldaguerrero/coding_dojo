<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
</head>
<body>
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="lang">
	        <tr>
	            <td><a href="/show/${lang.id}"><c:out value="${lang.name}"/></a></td>
	            <td><c:out value="${lang.creator}"/></td>
	            <td><c:out value="${lang.version}"/></td>
	            <td><a href="/delete/<c:out value="${lang.id}"/>">delete</a>
	       			| <a href="/languages/edit/${lang.id}">edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<h3>Add Language</h3>
	<form:form action="/add/lang" method="post" modelAttribute="langObj">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p> 
	    <input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>