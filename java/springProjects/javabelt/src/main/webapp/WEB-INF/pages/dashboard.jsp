<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<title>Courses</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<h3>Courses</h3><a href="/logout">logout</a>
	
	<form:form action="/enroll" method="post" modelAttribute="enrollObj">
		<form:hidden path="user" value="${user.id}"/>
			<table class="table table-striped" style="margin-left: 30%; width: 39%;">
			  <thead>
			    <tr>
			      <th scope="col">Course</th>
			      <th scope="col">Instructor</th>
			      <th scope="col">Capacity</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<form:form path="course">
				  	<c:forEach items="${courses}" var="course">
					    <tr>
					       <td><a href="/courses/${course.id}"><c:out value="${course.name}"/></a></td>
				           <td><c:out value="${course.id}"/></td>
				           <td><c:out value="${course.capacity}"/></td>
				           <td><button name="course" type="submit" value="${course.id}"></button> Add</td>
					    </tr>
				    </c:forEach>
			    </form:form>
			  </tbody>
			</table>
	</form:form>
	
	<a href="/courses/new">Add a course</a>
	    
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
</body>
</html>