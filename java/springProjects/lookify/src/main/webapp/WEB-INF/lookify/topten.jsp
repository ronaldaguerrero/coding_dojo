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
	
	<title>Top Ten Songs</title>
</head>
<body>
	
	<ul class="nav nav-pills nav-fill">
	  <li class="nav-item">
	    <a class="nav-link disabled">Top Songs</a>
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
	
	<h3>Top Ten Songs</h3>
	
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">Rating</th>
	      <th scope="col">Title</th>
	      <th scope="col">Artist</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${top}" var="song">
	    <tr>
	      <td>${song.rating}</td>
	      <td><a href="/show/${song.id}">${song.title}</a></td>
	      <td>${song.artist}</td>
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