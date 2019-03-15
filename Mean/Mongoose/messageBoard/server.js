let express = require('express');
let app = express();
let mongoose = require('mongoose');
let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

mongoose.connect("mongodb://localhost/messageBoard", { useNewUrlParser: true });
const commentSchema = new mongoose.Schema({
  name: {type: String, required: [true,'A name is required']},
  comment: {type: String, required: [true,'Comments must have content']},
}, {timestamps: true });

const messageSchema = new mongoose.Schema({
  name: {type: String, required: [true, "A name is required"], minlength: 3},
    message: {type: String, required: [true, "Messages must have content"], minlength: 3},
    comments: [commentSchema]
    }, {timestamps: true})

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

var Message = mongoose.model('messages', messageSchema);
var Comment = mongoose.model('comments', commentSchema);

app.post('/post_message', function (req, res) {
  Message.create(req.body, function (err, result) {
    if (err) { 
      console.log('we have an error');
        for(var key in err.errors){
            req.flash('messageform', err.errors[key].message);
          }
        res.redirect('/');
    } else {
      res.redirect('/');
      }
    });
});

app.post("/post_comment/:id", function(req, res){
    Comment.create({name: req.body.name, comment: req.body.comment}, function(err, comment) {
        if(err){
            console.log("~Something went wrong~");
            for(var key in err.errors){
                req.flash("commentform", err.errors[key].message);
            }
            res.redirect('/');
        }
        else{
            Message.findOneAndUpdate({_id: req.params.id}, {$push: {comments: comment}}, function(err, data) {
                if(err){
                    console.log("~Something went wrong~");
                    res.redirect('/');
                }
                else{
                    res.redirect('/');
                }
            })
        }
    })
});

app.get('/', function (req, res) {
  Message.find({},(function(err, ms) {
        if (err) res.render('/index', {errors: err});
        else {
            res.render('index', {ms: ms});
        }
    }))
});

app.listen(7000, function() {
  console.log("Listening on port 7000")
})