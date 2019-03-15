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
	
	<title>Add Song</title>
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
	
	<form:form action="/add/song" method="post" modelAttribute="looks" style="width:30%; margin-left:33%">
	  <div class="form-group">
	    <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title" class="form-control"/>
	  </div>
	  <div class="form-group">
	     <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist" class="form-control"/>
	  </div>
	  <div class="form-group">
	    <form:label path="rating">Rating (1-10)</form:label>
        <form:errors path="rating"/>
        <form:select path="rating" class="form-control">
        	<option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			  <option value="6">6</option>
			  <option value="7">7</option>
			  <option value="8">8</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			</form:select>
	  </div>
	  <input type="submit" value="Submit"/>
	</form:form>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>