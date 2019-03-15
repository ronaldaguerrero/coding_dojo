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
	<form:form action="/roll/dice" method="post" modelAttribute="playerPos" style="width:30%; margin-left:35%">
	  <div class="form-group">
	    <label style="width:30%; margin-left:35%">Roll the Dice:</label>
		<form:select path="id">
			<c:forEach items="${players}" var="p">
				<option value="${p.id}">${p.name}</option>
			</c:forEach>
		</form:select>
	  </div>
	  <input type="submit" value="Roll"/>
	</form:form>
	
	<a href="/roll/dice">Roll Dice</a>
	<p>Dice 1: ${die1} </p>
	<p>Dice 2: ${die2} </p>
</body>
</html>