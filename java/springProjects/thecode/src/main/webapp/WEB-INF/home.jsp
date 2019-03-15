<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Secret Code</title>
</head>
<body>
	<p style="color:red;"><c:out value="${error}"/></p>
	<p>What is the code?</p>
	<form action="/code" method="post">
		<input type="text" name="code" id="code"/>
		<input type="submit" value="Try Code"/> 
	</form>	
</body>
</html>