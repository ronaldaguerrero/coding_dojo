<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<title>Search</title>
</head>
<body>
	<ul class="nav nav-pills nav-fill">
	  <li class="nav-item">
	    <a class="nav-link" href="/search/topTen">Top Songs</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="/songs/new">Add New Song</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="/dashboard">Dashboard</a>
	  </li>
	  <li class="nav-item">
	    <form action="/search" method="post" >
		<input class="form" type="search" name="artist" placeholder="Artist Name">
		<input class="form" type="submit" value="Search Artists">
		</form>
	  </li>
	</ul>
	
	<h1 style="text-align:center;">Search</h1>
	
	<p style="text-align:center;">Songs by artist: <c:out value="${artist}"/></p>
	
	<table class="table table-striped" style="margin-left: 30%; width: 39%;">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Rating</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${songs}" var="song">
	    <tr>
	      <td><a href="/show/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><form action="/delete/${song.id}" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete"></form></td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>