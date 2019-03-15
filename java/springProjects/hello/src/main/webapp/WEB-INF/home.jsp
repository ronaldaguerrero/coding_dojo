<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello... <c:out value="${name}"/></title>
</head>
<body>
	<h1>Hello <c:out value="${name}"/></h1>
	
	<p>Welcome to SpringBoot!</p>

</body>
</html>