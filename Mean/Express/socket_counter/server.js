// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");
// create the express app
var app = express();

var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));

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



io.on('connection', function connection(socket){ // 2 connected, execute function
	console.log('socket connection');
	console.log('socket id:', socket.id);
	var count = 0;
	socket.on('counter', function counter(){ // 5 on receive, execute emite to index
		console.log('counter');
		if (count == 0){
			count++;
		}
		else {
			count++;
		}
		console.log('this is the count ' + count);
		socket.emit('count', {response: count});
	});
	socket.on('reset', function reset(){
		count = 0;
		console.log('reset');
		socket.emit('count', {response: count});
	});
});