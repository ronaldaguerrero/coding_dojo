let express = require('express');
let app = express();
let mongoose = require('mongoose');
let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

mongoose.connect("mongodb://localhost/dog_dojo", { useNewUrlParser: true });

require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);


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



app.listen(8000, function() {
  console.log("Listening on port 8000")
})