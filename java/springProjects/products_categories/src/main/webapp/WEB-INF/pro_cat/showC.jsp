<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${cat.name}"/></h1>
	
	<h3>Products:</h3>
	<ul>
	<c:forEach items="${cat.products}" var="prod">
		<li>${prod.name}</li>
	</c:forEach>
	</ul>
	
	
	<form:form action="/linkP/${cat.id}" method="post" modelAttribute="catObj" style="width:30%; margin-left:35%">
	  <div class="form-group">
	    <label>Add Product:</label>
        <select name="prodChoice">
			<c:forEach items="${prod}" var="prod">
				<option value="${prod.id}">${prod.name}</option>
			</c:forEach>
		</select>
	  </div>
	  <input type="submit" value="Add"/>
	</form:form>
</body>
</html>