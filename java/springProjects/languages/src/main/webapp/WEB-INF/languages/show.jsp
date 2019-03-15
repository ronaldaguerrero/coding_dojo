<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Language Show Page</title>
</head>
<body>    
	<p>Name: <c:out value="${langObj.name}"/></p>
	<p>Creator: <c:out value="${langObj.creator}"/></p>
	<p>Version: <c:out value="${langObj.version}"/></p>
	<a href="/languages/edit/${langObj.id}">Edit Language</a>
	<a href="/delete/<c:out value="${langObj.id}"/>">Delete</a>
    <a href="/languages">Dashboard</a>
</form>
</body>
</html>