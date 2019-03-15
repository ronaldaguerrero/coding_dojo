<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.fName}" /></h1>
	<a href="/logout">Logout</a>
	
	<p>Here are some of the events in your state:</p>
	
	<a href="/events">Event Page</a>
	<table>
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action / Status</th>
		</tr>
		<tbody>
	        <c:forEach items="${e}" var="e">
		        <tr>
		            <td><a href="/events/${e[0]}"><c:out value="${e[1]}"/></a></td>
		            <td><c:out value="${e[2]}"/>
		        	<td><c:out value="${e[3]}"/>
		        	<td><c:out value="${e[4]}"/>
		            <td><a href="/join/event/<c:out value="${e[0]}"/>">join</a>
			            | <a href="/cancel/attendee/<c:out value="${e[0]}"/>">cancel</a>
		       			| <a href="/edit/event/<c:out value="${e[0]}"/>">edit</a>
		       			| <a href="/delete/event/<c:out value="${e[0]}"/>">delete</a>
		       		</td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<p>Here are some of the events in other states:</p>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action / Status</th>
		</tr>
		<tbody>
	        <c:forEach items="${nonE}" var="nE">
		        <tr>
		            <td><a href="/events/${nE[0]}"><c:out value="${nE[1]}"/></a></td>
		            <td><c:out value="${nE[2]}"/>
		        	<td><c:out value="${nE[3]}"/>
		        	<td><c:out value="${nE[4]}"/>
		            <td><a href="/join/event/<c:out value="${nE[0]}"/>">join</a>
			            | <a href="/cancel/attendee/<c:out value="${nE[0]}"/>">cancel</a>
		       			| <a href="/edit/event/<c:out value="${nE[0]}"/>">edit</a>
		       			| <a href="/delete/event/<c:out value="${nE[0]}"/>">delete</a>
		       		</td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<h2>Create an Event</h2>
	<form:form method="POST" action="/create/event" modelAttribute="eventObj">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name"/>
            <form:input type="text" path="name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:errors path="date"/>
            <form:input type="date" path="date"/>
        </p>
        <p>
            <form:label path="city">City:</form:label>
            <form:errors path="city"/>
            <form:input type="text" path="city"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:errors path="state"/>
            <form:input type="text" path="state"/>
        </p>
        <input type="submit" value="Add Event"/>
    </form:form>
	
</body>
</html>