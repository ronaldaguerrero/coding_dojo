// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));

// require session
var session = require('express-session');
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

// set up other middleware, such as session
const flash = require('express-flash');
app.use(flash());
app.post('/users', function (req, res){
    var user = new User(req.body);
    user.save(function(err){
        if(err){
            // if there is an error upon saving, use console.log to see what is in the err object 
            console.log("We have an error!", err);
            // adjust the code below as needed to create a flash message with the tag and content you would like
            for(var key in err.errors){
                req.flash('registration', err.errors[key].message);
            }
            // redirect the user to an appropriate route
            res.redirect('/');
        }
        else {
            res.redirect('/');
        }
    });
});


// Require path
var path = require('path');
// Require mongoose
var mongoose = require('mongoose');
// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.copy
mongoose.connect('mongodb://localhost/basic_mongoose');

var UserSchema = new mongoose.Schema({
 name: { type: String, required: true, minlength: 6},
 age: { type: Number, min: 1, max: 150 },
 }, {timestamps: true})

mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'


// Using the User Schema...
// ...retrieve all records matching {}
User.find({}, function(err, users) {
 // Retrieve an array of users
 // This code will run when the DB is done attempting to retrieve all matching records to {}
 	console.log('all users: ' + users);
})

// ...retrieve all records matching {name:'Jessica'}
User.find({name:'zubac'}, function(err, users) {
 // Retrieve an array of users matching the name. Even if 1 record is found, the result will be an array the size of 1, with 1 object inside. (Notice, if we are expecting to retrieve one record, we may want to use findOne and retrieve the object as oppose to an array the size of one.copy
 // This code will run when the DB is done attempting to retrieve all matching records to {name:'Jessica'}
 console.log('specific user: ' + users);
})

// ...retrieve 1 record (the first record found) matching {} 
User.findOne({}, function(err, user) {
 // Retrieve 1 object
 // This code will run when the DB is done attempting to retrieve 1 record.
 console.log('one user: ' + user);
})

// // ...create a new instance of the User Schema and save it to the DB.
// var userInstance = new User()
// userInstance.name = 'Andriana'
// userInstance.age = 29
// userInstance.save(function(err){
//  // This code will run when Mongo has attempted to save the record.
//  // If (err) exists, the record was not saved, and (err) contains validation errors.
//  // If (err) does not exist (undefined), Mongo saved the record successfully.
// })

// // ...delete all records of the User Model
// User.remove({}, function(err){
//  // This code will run when the DB has attempted to remove all matching records to {}
// })


// Use native promises (only necessary with mongoose versions <= 4)
mongoose.Promise = global.Promise;

// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
app.get('/', function(req, res) {
    // This is where we will retrieve the users from the database and include them in the view page we will be rendering.
    User.find({}, function(err, users){
    	if (err) { console.log(err); }
    	res.render('index', {users: users});
    })
})
// This is the route that we already have in our server.js
// When the user presses the submit button on index.ejs it should send a post request to '/users'.  In
//  this route we should add the user to the database and then redirect to the root route (index view).
app.post('/users', function(req, res) {
  console.log("POST DATA", req.body);
  // create a new User with the name and age corresponding to those from req.body
  var user = new User({name: req.body.name, age: req.body.age});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  user.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a user!');
    }
    res.redirect('/');
  })
})


// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})
