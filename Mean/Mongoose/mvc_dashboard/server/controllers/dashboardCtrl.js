let mongoose = require('mongoose');
let Dog = mongoose.model('dogs');

// <!-- tip to easily see objects printed in full instead of [object Object] -->
// 	<!-- <%- JSON.stringify(messages) %>  -->
// 	<!-- based on the structure of your messages, determine how to display them -->
// 	<!-- <% if(messages.registration) { %>
// 	     <% for (var x of messages.registration) { %>
// 	      <h3><%= x %></h3>
// 	     <% } %>
// 	 <% } %> -->

module.exports = {
	index: function (req, res) {
	  Dog.find({}, null, {sort: {createdAt: -1}}, function(err, dogs) {
	        if (err) res.render('/', {errors: err});
	        else {
	            console.log(dogs);
	            res.render('index', {dogs: dogs});
	        }
	    })
	},

	create: function (req, res) {
	    res.render('dogs');
	},

	add: function (req, res) {
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
	},

	edit: function(req, res) {
	    Dog.findOne({_id: req.params.id}, function(err, dog) {
	        console.log(dog);
	        res.render('edit', {dog:dog});
	    })
	},
	
	show: function(req, res) {
	    Dog.findOne({_id: req.params.id}, function(err, dog) {
	        console.log(dog);
	        res.render('show', {dog:dog});
	    })
	},
	
	update: function(req, res) {
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
	},
	
	destroy: function(req,res){
	    Dog.remove({_id: req.params.id}, function(err){
	        res.redirect('/');
	    })
	}
}

