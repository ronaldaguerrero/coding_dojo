<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Current visit count</title>
</head>
<body>
	<p>You have visited <a href="/counter">localhost:8080</a> ${sessionScope.count} times.</p>
	<a href="/">Test another visit?</a>
	<a href="/reset">Reset counter</a>
</body>
</html>