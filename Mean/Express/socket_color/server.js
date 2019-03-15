// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");
// create the express app
var app = express();

var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));

// use static
app.use(express.static(__dirname + "/static"));

// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs')

// create server and socket
const server = app.listen(1337);
var io = require('socket.io')(server);
var counter = 0;

app.get('/', function(req, res) {
 res.render("index");
})

var color = "";

io.on("connection", function(socket){ // 2 connected, execute function
	console.log("Connected");
	socket.emit("launch", { // 3 set background
		bgc : color
	});
	socket.broadcast.emit("launch", {
		bgc : color
	});

	socket.on("greenP", function(){ // 5 on receive, execute function
		socket.emit("greenBG"); // 6 emit socket 
		socket.broadcast.emit("greenBG"); // 7 broadcast
		color = "green"
	});
	socket.on("blueP", function(){
		socket.emit("blueBG");
		socket.broadcast.emit("blueBG");
		color = "blue"
	});
	socket.on("pinkP", function(){
		socket.emit("pinkBG");
		socket.broadcast.emit("pinkBG");
		color = "pink"
	});
});