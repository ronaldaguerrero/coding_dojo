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
	<h1><c:out value="${prod.name}"/></h1>
	
	<h3>Categories:</h3>
	<ul>
	<c:forEach items="${prod.categories}" var="cat">
		<li>${cat.name}</li>
	</c:forEach>
	</ul>
	
	
	<%-- <form:form action="/link/${prod.id}" method="post" modelAttribute="prodObj" style="width:30%; margin-left:35%">
	  <div class="form-group">
	    <label>Add Category:</label>
        <select name="catChoice">
			<c:forEach items="${cat}" var="cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
	  </div>
	  <input type="submit" value="Add"/>
	</form:form> --%>
	
	<form:form action="/linkC" method="post" modelAttribute="prodObj" style="width:30%; margin-left:35%">
		<form:hidden path="product" value="${prod.id}"/>
		  <div class="form-group">
		    <label for="category">Add Category:</label>
	        <form:select path="category">
				<c:forEach items="${cat}" var="cat">
					<option value="${cat.id}">${cat.name}</option>
				</c:forEach>
			</form:select>
		  </div>
		  <input type="submit" value="Add"/>
	</form:form>
</body>
</html>