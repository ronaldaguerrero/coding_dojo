<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<p>Name: <c:out value="${lang.name}"/></p>
	<p>Creator: <c:out value="${lang.creator}"/></p>
	<p>Version: <c:out value="${lang.version}"/></p>
	<a href="/languages/${lang.id}/edit">Edit Book</a>
	<form action="/lang/${lang.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
</form>
</body>
</html>