<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="test.css">
	<meta charset="UTF-8">
	<title>test</title>
</head>
<body>
	<!-- forloops work as well! -->
    <% int h = 0; %>
    <% int w = 0; %>
    <% h = Integer.parseInt(request.getParameter("height"));%>
    <% w = Integer.parseInt(request.getParameter("width"));%>
    <h1>Checkerboard <%= w %>w X <%= h %>h</h1>
    <table>
    <% for(int index = 0; index < h; index++) { %>
        <%if(index%2 ==0){%>
        <tr>
        	<% for(int a = 0; a < w; a++) { %>
        	<%if(a%2 ==0){%>
        		<td class ='c1'></td>
        		<%} else {%>
        			<td class ='c2'></td>
        		<% } %>
        	<% } %>
        </tr>
        <%} else {%>
        <tr>
        	<% for(int b = 0; b < w; b++) { %>
        	<%if(b%2 ==0){%>
        		<td class ='c2'></td>
        		<%} else {%>
        		<td class ='c1'></td>
        		<% } %>
        	<% } %>
        </tr>
        <% } %>
    <% } %>
    </table>
</body>
</html>