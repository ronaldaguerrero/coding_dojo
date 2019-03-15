// set token to player rolling dice
var player1Id = 0;
var player2Id = 0;
var player3Id = 0;
var player4Id = 0;

var img1 = document.createElement("IMG")
img1.setAttribute("src", "/images/1_top_hat.png");
img1.setAttribute("p1Pos", "absolute");

var img2 = document.createElement("IMG")
img2.setAttribute("src", "/images/2_money_bag.png");
img2.setAttribute("p2Pos", "absolute");

var img3 = document.createElement("IMG")
img3.setAttribute("src", "/images/3_penguin.png");
img3.setAttribute("p3Pos", "absolute");

function move(){
	document.getElementById(document.getElementById("p1Pos").value).setAttribute("p1Pos", "relative");
	document.getElementById(document.getElementById("p1Pos").value).appendChild(img1);
	document.getElementById(document.getElementById("p2Pos").value).setAttribute("p2Pos", "relative");
	document.getElementById(document.getElementById("p2Pos").value).appendChild(img2);
	document.getElementById(document.getElementById("p3Pos").value).setAttribute("p3Pos", "relative");
	document.getElementById(document.getElementById("p3Pos").value).appendChild(img3);
}

move();

var rollerId = document.getElementById("playerThatRolled").value;
console.log("roller id is : " + rollerId);
 
// show appropriate # of tokens based on # of players

function gameOver(){
	
}