let mongoose = require('mongoose');
let Quote = mongoose.model('quotes');

module.exports = {
	index: function (req, res){
		Quote.find({}, function(err, quotes) {
	    if (err) { console.log(err); }
	    res.render('quotes', { quotes: quotes });
	  });
	},
	create: function (req, res){
		 Quote.create(req.body, function (err, result) {
	    if (err) { console.log(err); }
	    res.redirect('/quotes');
	  });
	}

}