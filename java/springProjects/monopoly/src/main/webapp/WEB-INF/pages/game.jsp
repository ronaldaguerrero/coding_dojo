<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8 />
	<title>Monopoly</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
	<link rel="stylesheet" href="css/style.css">
	<style>
		body{
			background-image: url(/images/background1.jpg);
		}
	</style>
</head>
<body>
	<div class="responsive">

		<div class="mainSquare">

			<div class="row top">
				<div class="square2" id="21"><span class="corner corner1">free <br /> parking</span></div>
				<div class="square1" id="22">
					<div class="header header-top red"></div>
					<div class="firstLine firstLine-top rotation2">kentucky <br /> avenue</div>
				</div>
				<div class="square1" id="23">					
					<div class="firstLine firstLine-top no-color rotation2">chance</div>
				</div>
				<div class="square1" id="24">
					<div class="header header-top red"></div>
					<div class="firstLine firstLine-top rotation2">indiana <br /> avenue</div>
				</div>
				<div class="square1" id="25">
					<div class="header header-top red"></div>
					<div class="firstLine firstLine-top rotation2">illinios <br /> avenue</div>
				</div>
				<div class="square1" id="26">
					<div class="firstLine firstLine-top no-color rotation2">b. & o. <br /> railroad</div>
				</div>
				<div class="square1" id="27">
					<div class="header header-top yellow"></div>
					<div class="firstLine firstLine-top rotation2">atlantic <br /> avenue</div>
				</div>
				<div class="square1" id="28">
					<div class="header header-top yellow"></div>
					<div class="firstLine firstLine-top rotation2">ventnor <br /> avenue</div>
				</div>
				<div class="square1" id="29">					
					<div class="firstLine firstLine-top no-color rotation2">water <br /> works</div>
				</div>
				<div class="square1" id="30">
					<div class="header header-top yellow"></div>
					<div class="firstLine firstLine-top rotation2">marvin <br /> gardens</div>
				</div>
				<div class="square2" id="31"><span class="corner corner2">go to<br />jail</span></div>
			</div>
			
			<div class="row center">
				<div class="square2">
					<div class="squareSide" id="20">
						<div class="headerSide header-left orange"></div>
						<div class="firstLine firstLine-left rotation1">new york <br /> avenue</div>
					</div>
					<div class="squareSide" id="19">
						<div class="headerSide header-left orange"></div>
						<div class="firstLine firstLine-left rotation1">tennessee <br /> avenue</div>
					</div>
					<div class="squareSide" id="18">						
						<div class="firstLine firstLine-left no-color rotation1">community<br /> chest</div>
					</div>
					<div class="squareSide" id="17">
						<div class="headerSide header-left orange"></div>
						<div class="firstLine firstLine-left rotation1">st.james <br />place</div>
					</div>
					<div class="squareSide" id="16">						
						<div class="firstLine firstLine-left no-color rotation1">pennsylvania<br> railroad</div>
					</div>
					<div class="squareSide" id="15">
						<div class="headerSide header-left purple"></div>
						<div class="firstLine firstLine-left rotation1">virginia<br /> avenue</div>
					</div>
					<div class="squareSide" id="14">
						<div class="headerSide header-left purple"></div>
						<div class="firstLine firstLine-left rotation1">states<br /> avenue</div>
					</div>
					<div class="squareSide" id="13">						
						<div class="firstLine firstLine-left no-color rotation1">electric<br />company</div>
					</div>
					<div class="squareSide" id="12">
						<div class="headerSide header-left purple"></div>
						<div class="firstLine firstLine-left rotation1">st. charles<br />place</div>
					</div>
				</div>
				<div class="square9" >
					<div class="card-box card-blue">
						<div class="card-blue-inside"></div>
					</div>
					<div class="logoBox">
						<span class="logoName">monopoly</span>
					</div>
					<div class="card-box card-orange">
						<div class="card-orange-inside"></div>						
					</div>
				</div>
				<div class="square2">
					<div class="squareSide" id="32">
						<div class="headerSide header-right green"></div>
						<div class="firstLine firstLine-right rotation3">pacific<br /> avenue</div>
					</div>
					<div class="squareSide" id="33">
						<div class="headerSide header-right green"></div>
						<div class="firstLine firstLine-right rotation3">north<br />carolina<br />avenue</div>
					</div>
					<div class="squareSide" id="34">						
						<div class="firstLine firstLine-right no-color rotation3">community<br />chest</div>
					</div>
					<div class="squareSide" id="35">
						<div class="headerSide header-right green"></div>
						<div class="firstLine firstLine-right rotation3">pennsylvania<br /> avenue</div>
					</div>
					<div class="squareSide" id="36">						
						<div class="firstLine firstLine-right no-color rotation3">short<br /> line</div>
					</div>
					<div class="squareSide" id="37">
						<div class="firstLine firstLine-right no-color rotation3">chance</div>
					</div>
					<div class="squareSide" id="38">						
						<div class="headerSide header-right blue"></div>
						<div class="firstLine firstLine-right rotation3">park<br /> place</div>
					</div>
					<div class="squareSide" id="39">						
						<div class="firstLine firstLine-right no-color rotation3">luxury<br /> tax</div>
					</div>
					<div class="squareSide" id="40">
						<div class="headerSide header-right blue"></div>
						<div class="firstLine firstLine-right rotation3">Boardwalk</div>
					</div>
				</div>
			</div>

			<div class="row top">
				<div class="square2" id="11">
					<span class="corner4-left">just</span>
					<div class="squareCorner">
						<span class="corner corner4">in <br />jail</span>
					</div>
					<span class="corner4-bottom">visiting</span>
				</div>
				<div class="square1" id="10">
					<div class="header header-bottom lightblue"></div>
					<div class="firstLine firstLine-bottom">connecticut avenue</div>
				</div>
				<div class="square1" id="9">
					<div class="header header-bottom lightblue"></div>
					<div class="firstLine firstLine-bottom">vermont<br /> avenue</div>
				</div>
				<div class="square1" id="8">
					<div class="firstLine firstLine-bottom no-color">chance</div>
				</div>
				<div class="square1" id="7">
					<div class="header header-bottom lightblue"></div>
					<div class="firstLine firstLine-bottom">oriental<br /> avenue</div>
				</div>
				<div class="square1" id="6">					
					<div class="firstLine firstLine-bottom no-color">reading<br /> railroad</div>
				</div>
				<div class="square1" id="5">
					<div class="firstLine firstLine-bottom no-color">income<br /> tax</div>
				</div>
				<div class="square1" id="4">
					<div class="header header-bottom brown"></div>
					<div class="firstLine firstLine-bottom">baltic<br /> avenue</div>
				</div>
				<div class="square1" id="3">
					<div class="firstLine firstLine-bottom no-color">community<br /> chest</div>
				</div>
				<div class="square1" id="2">
					<div class="header header-bottom brown"></div>
					<div class="firstLine firstLine-bottom">mediter-<br /> ranean <br /> avenue</div>
				</div>
				<div class="square2" id="1">
					<span class="corner corner3">collect<br />M200 salary<br />as you pass</span>
				</div>
			</div>

		</div>

	</div>
	
	 <div id="diceDiv" style="position: absolute; top:0%; width:5%; text-align:center; margin-left:2.5%; text-transform:none;">
		<form:form action="/roll/dice" method="post" modelAttribute="playerPos">
		  <div class="form-group">
		    <label style="text-transform:none;">Roll the Dice:</label>
			<form:select path="id" style="margin-bottom: 10%; margin-top:10%;">
				<c:forEach items="${players}" var="p">
					<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</form:select>
			<input type="submit" value="Roll"/>
		  </div>
		</form:form>
		<p>Dice 1: ${die1} </p>
		<p>Dice 2: ${die2} </p>
		<p>Last roller: ${rollerName}</p>
	</div>
	
	
	<input type="hidden" id="position" value="${landedOnId}">
	<input type="hidden" id="playerThatRolled" value="${pId}">
	<input type="hidden" id="p1Pos" value="${p1Pos}">
	<input type="hidden" id="p2Pos" value="${p2Pos}">
	<input type="hidden" id="p3Pos" value="${p3Pos}">
	
	<div id="buyDiv" style="position: absolute;top:-50px; padding:1%; right:35%; text-transform:none;">
		<form:form action="/buy" method="post" modelAttribute="buyProp">
		    <label>Buy Property:</label>
	        <form:select path="property">
				<c:forEach items="${unO}" var="u">
					<option value="${u[0]}">${u[1]}</option>
				</c:forEach>
			</form:select>
			<form:select path="player">
				<c:forEach items="${players}" var="p">
					<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</form:select>
		  	<input type="submit" value="Buy"/>
		</form:form>
	</div>

	<script type="text/javascript" src="js/script.js"></script>
	
	<div id="tokenObj" style="position: absolute; top:0%; right:0%; width:10%; text-transform:none; text-align:center;">
		<p id="p1Token">${p1Name}'s Token: <img src="/images/1_top_hat.png"> $ ${p1Money}</p>
		<p id="p2Token">${p2Name}'s Token: <img src="/images/2_money_bag.png"> $ ${p2Money}</p>
		<p id="p3Token">${p3Name}'s Token: <img src="/images/3_penguin.png"> $ ${p3Money}</p>
		<!-- <p id="p4Token">Player 4 Token: <img src="/images/4_race_car.png"></p> -->
	</div>
	
	<p id="doubleDiv" style="position: absolute; left:1%; top:-80px;">${doubles}</p>
	<p id="msgDiv" style="position: absolute; right:42%; top:-80px;">You landed on: ${propName}</p>
	
	<span style="margin-left:11%; font-size:20px; font-weight: bold;">${p1Name}'s properties</span>
	<span style="margin-left:20%; font-size:20px; font-weight: bold;">${p2Name}'s properties</span>
	<span style="margin-left:20%; font-size:20px; font-weight: bold;">${p3Name}'s properties</span>
	
	<div id="propBox" style="width:100%; text-transform: none;">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Property Name</th>
		      <th scope="col">Property Rent</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${p1Props}" var="p1">
		    <tr>
		      <td>${p1[0]}</td>
		      <td>$ ${p1[1]}</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Property Name</th>
		      <th scope="col">Property Rent</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${p2Props}" var="p2">
		    <tr>
		      <td>${p2[0]}</td>
		      <td>$ ${p2[1]}</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Property Name</th>
		      <th scope="col">Property Rent</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${p3Props}" var="p3">
		    <tr>
		      <td>${p3[0]}</td>
		      <td>$ ${p3[1]}</td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	
	<a href="end/game" style="position: absolute; bottom:-20%;">End Game</a>
</body>
</html>