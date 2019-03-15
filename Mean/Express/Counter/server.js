// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");
// create the express app
var app = express();
//create the sesion app
var session = require('express-session');

var bodyParser = require('body-parser');
// use it!
app.use(bodyParser.urlencoded({ extended: true }));
// static content
app.use(express.static(path.join(__dirname, "./static")));

//setting up session?
app.set('trust proxy',1);
app.use(session({
	secret: 'keyboard marvel',
	resave: false,
	saveUninitialized: true,
	cookie: { maxAge: 60000 }
}))

app.use(function(req, res, next){
	res.locals.user = req.session.user;
	next();
})

// setting up ejs and our views folder
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view

app.get('/', function(req, res) {
	if (req.session.count == null){
		req.session.count = 1;
	} else {
		req.session.count += 1;
	}
 res.render("index", {count : req.session.count});
})

app.get('/add_two', function(req, res) {
	req.session.count += 1;
 res.redirect("/");
})

app.get('/destroy_session', function(req, res) {
	req.session.destroy();
 res.redirect("/");
})





// app.post('/users', function (req, res){
//     // set the name property of session.  
//     req.session.count = 1
//     console.log(req.session.count);
//     //code to add user to db goes here!
//     // redirect the user back to the root route. 
//     res.redirect('/');
// });


// tell the express app to listen on port 8000
app.listen(8000, function() {
 console.log("listening on port 8000");
});
