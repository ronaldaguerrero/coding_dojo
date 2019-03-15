let express = require('express');
let app = express();
let mongoose = require('mongoose');
let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

mongoose.connect("mongodb://localhost/dog_dojo", { useNewUrlParser: true });
const dogSchema = new mongoose.Schema({
  name: { type: String, required: true, minlength: 1},
  breed: { type: String, required: true, minlength: 1},
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

const Dog = mongoose.model('dogs', dogSchema);

app.get('/dogs/new', function (req, res) {
    res.render('dogs');
  });

app.post('/add', function (req, res) {
  Dog.create(req.body, function (err, result) {
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


app.get('/', function (req, res) {
  Dog.find({}, null, {sort: {createdAt: -1}}, function(err, dogs) {
        if (err) res.render('/', {errors: err});
        else {
            console.log(dogs);
            res.render('index', {dogs: dogs});
        }
    })
})

app.get('/dogs/edit/:id', function(req, res) {
    Dog.findOne({_id: req.params.id}, function(err, dog) {
        console.log(dog);
        res.render('edit', {dog:dog});
    })
})

app.get('/dogs/:id', function(req, res) {
    Dog.findOne({_id: req.params.id}, function(err, dog) {
        console.log(dog);
        res.render('show', {dog:dog});
    })
})

app.post('/update/:id', function(req, res) {
    console.log("POST DATA", req.body);
    Dog.update({_id: req.params.id},
      {name: req.body.name,
      breed: req.body.breed},
      function(err){
        if(err) {
            console.log('something went wrong');
            console.log(dog.errors);
            res.redirect(`/edit/${req.params.id}`)
        } else {
            res.redirect(`/`);
        }
    })
})

app.post('/dogs/destroy/:id', function(req,res){
    Dog.remove({_id: req.params.id}, function(err){
        res.redirect('/');
    })
})

app.listen(8000, function() {
  console.log("Listening on port 8000")
})