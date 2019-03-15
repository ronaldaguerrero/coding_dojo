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
	            <td><c:out value="${lang.name}"/></td>
	            <td><c:out value="${lang.creator}"/></td>
	            <td><c:out value="${lang.version}"/></td>
	            <td><form action="/delete/${lang.id}" method="post">
	   				<input type="hidden" name="_method" value="delete">
	    			<input type="submit" value="Delete">
					</form> 
	       			| <a href="/languages/edit/${lang.id}">edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<h1>Add Language</h1>
	<form action="/add/lang" method="post">
	    <p>Name: 
	     	<%-- <form:label path="name">Name</form:label> --%>
	     	<input type="text" name="name"/>
	        <%-- <form:errors path="name"/> --%>	   
	    </p>
	    <p>Creator:
	        <%-- <form:label path="creator">Creator</form:label> --%>
	        <input type="text" name="creator"/>
	        <%-- <form:errors path="creator"/> --%>
	    </p>
	    <p>Version:
	        <!-- <label path="version">Version</label> -->
	        <input type="text" name="version"/>
	        <%-- <form:errors path="version"/> --%>
	    </p>
	    <input type="submit" value="Submit"/>
	</form>
	
</body>
</html>