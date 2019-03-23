let mongoose = require('mongoose');
let Product = mongoose.model('products');

module.exports = {
	index: function (req, res) {
		Product.find({}, function(err, products){
			if (err) {
				res.json(err);
	        } else {
	            res.json({products});
	        }
		})
	},

	show: function (req, res){
		Product.find({_id: req.params.id}, function (err, product){
			if (err) {
				res.json(err);
	        } else {
	            res.json({product});
	        }
		})
	},

	create: function (req, res) {
		Product.create(req.body, function (err, product){
			if (err) {
				// console.log('error from ctrl');
				// console.log(err.message);
				res.json(err);
	        } else {
	            res.json({product});
	        }
		})
	},

	update: function (req, res) {
		Product.updateOne({_id: req.params.id}, {$set: req.body}, { runValidators: true }, function (err, product){
			if (err) {
				// console.log('error from ctrl');
				// console.log(err.message);
				res.json(err);
	        } else {
	            res.json(product);
	        }
		})
	},

	delete: function (req, res) {
		Product.deleteOne({_id: req.params.id}, function (err, product){
			if (err) {
				res.json(err);
	        } else {
	            res.json(product);
	        }
		})
	}
}