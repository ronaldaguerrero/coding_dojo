let mongoose = require('mongoose');
let Person = mongoose.model('persons');

module.exports = {
	index: function (req, res) {
		Person.find({}, function(err, persons){
			if (err) res.render('/', {errors: err});
	        else {
	            console.log(persons);
				res.json({persons:persons});
	        }
		})
	},

	create: function (req, res) {
		var personInst = new Person();
		personInst.name = req.params.name;
		personInst.save(function(err){
			if (err) res.render('/', {errors: err});
	        else {
	            res.redirect('/');
	        }
		})
	},

	remove: function (req, res){
		Person.remove({name: req.params.name}, function (err){
			if (err) res.render('/', {errors: err});
	        else {
	            res.redirect('/');
	        }
		})
	},

	show: function (req, res){
		Person.find({name: req.params.name}, function (err, person){
			if (err) res.render('/', {errors: err});
	        else {
	            res.json({person:person});
	        }
		})
	}

}
