<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result Page</title>
</head>
<body>
	<h1>Submitted Info</h1>
	<p>
		Your Name: <c:out value="${name}" />
	</p>
	<p>
		Location: <c:out value="${loc}" />
	</p>
	<p>
		Language: <c:out value="${lang}" />
	</p>
	<p>
		Comment: <c:out value="${comm}" />
	</p>			
</body>
</html>