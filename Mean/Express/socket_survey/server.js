const express = require('express');
const app = express();

app.use(express.static(__dirname + "/public"));

// create server and socket
const server = app.listen(1337);
var io = require('socket.io')(server);
var counter = 0;

var path = require("path");
// create the express app
var bodyParser = require('body-parser');
// use it!


app.use(bodyParser.urlencoded({ extended: true }));

// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs')

app.get('/', function(req, res) {
 res.render("index");
})

    
io.on('connection', function connection(socket){ // 2 connected, execute function
	console.log('socket connection');
	console.log('socket id:', socket.id);

	socket.on('posting_form', function posting(data){ // 5 on receive, execute emite to index
	console.log(data);
	console.log('posting');
	var random_number = Math.floor((Math.random() * 1000) + 1);
	socket.emit('updated_message', {response: data}); // 6, send data
	socket.emit('random_number', {response: random_number}); // 8, send random num
	});
});

