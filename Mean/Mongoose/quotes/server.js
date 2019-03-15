let express = require('express');
let app = express();
let mongoose = require('mongoose');
let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

mongoose.connect("mongodb://localhost/quoting_dojo", { useNewUrlParser: true });
const quoteSchema = new mongoose.Schema({
  name: { type: String, required: true, minlength: 1},
  quote: { type: String, required: true, minlength: 1},
}, {timestamps: true });

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

const Quote = mongoose.model('quotes', quoteSchema);

app.get('/', function (req, res) {
  Quote.find({}, function(err, quotes) {
    if (err) { console.log(err); }
    res.render('quotes');
  });
});

app.post('/quotes', function (req, res) {
  Quote.create(req.body, function (err, result) {
    if (err) { 
      console.log('we have an error', err);
        for(var key in err.errors){
            req.flash('registration', err.errors[key].message);
          }
        res.redirect('/');
    } else {
      res.redirect('/');
      }
    });
});


app.get('/quotes', function (req, res) {
  Quote.find({}, null, {sort: {createdAt: -1}}, function(err, quotes) {
        if (err) res.render('/', {errors: err});
        else {
            console.log(quotes);
            res.render('show', {quotes: quotes});
        }
    })
})

app.listen(8000, function() {
  console.log("Listening on port 8000")
})