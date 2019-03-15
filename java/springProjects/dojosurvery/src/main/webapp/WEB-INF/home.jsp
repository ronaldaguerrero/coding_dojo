<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Survey Home</title>
	<style>
		form{
			margin-bottom:8px;
		}
		div{
			height: 500px;
			width: 300px;
			font-family: Arial, Helvetica, sans-serif;
			position: absolute;
			left: 20%;
			top: 20%;
		}
		p{
			display: inline-block;
			margin-top: 0px;
			margin-bottom: 7px;
		}
		select{
			margin-left: 10px;
		}
		button{
			margin-left: 175px;
		}
	</style>
</head>
<body>
	<div>
	<form action="/register" method="post">
		<p>
			<label for="name">Your Name:</label>
			<input type="text" name="name" id="name" />
		</p>
		<p>
			<label for="location">Location: </label>
			<select name="loc" id="location">
				<option value="BUR">Burbank</option>
				<option value="LA">Los Angeles</option>
				<option value="LB">Long Beach</option>
				<option value="SF">San Francisco</option>
				<option value="NY">New York</option>
			</select>
		</p>
		<p>
			<label for="language">Language: </label>
			<select name="lang" id="language">
				<option value="py">Python</option>
				<option value="js">JavaScript</option>
				<option value="mean">Mean</option>
				<option value="ja">Java</option>
			</select>
		</p>
		<p>
			<label for="comment">Comment (Optional): </label>
			<textarea name="comm" id="comment" cols="40" rows="4"></textarea>
		</p>
		<input type="submit" value="Add" />
	</form>
	</div>
	
</body>
</html>