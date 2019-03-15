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

var users = [];

var messages = [];

var user_check = function(user) {
  var users_count = users.length;

  for (var i = 0; i < users_count; i++) {
    if (user == users[i]) {
      return true;
    }
  }
  return false;
}


io.on("connection", function(socket){
	console.log("Connected");
	socket.on("pageLoad", function(data){ // 3 receive name and run if else
      if(user_check(data.user) === true) {
        socket.emit("existingUser", {error: "This user already exits"})
      } else {
        users.push(data.user); // 4 push user to array
        socket.emit("loadMessages", {currentUser: data.user, messages: messages}) // 5 send user and messages to client
      }
    })

    socket.on("newMessage", function(data){
      messages.push({name: data.user, message: data.message}) // receive & push user and message from client to array
      io.emit("postNewMessage", {newMessage: data.message, user: data.user}) // send new message to client
    })
    

  })