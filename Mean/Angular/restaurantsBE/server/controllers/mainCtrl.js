let mongoose = require('mongoose');
let Rating = mongoose.model('ratings');
let Restaurant = mongoose.model('restaurants');

module.exports = {
	index: function (req, res) {
		Restaurant.find({}, function(err, restaurants){
			if (err) {
				res.json(err);
	        } else {
	            res.json({restaurants});
	        }
		})
	},

	show: function (req, res){
		Restaurant.find({_id: req.params.id}, function (err, restaurant){
			if (err) {
				res.json(err);
	        } else {
	            res.json({restaurant});
	        }
		})
	},

	create: function (req, res) {
		Restaurant.create(req.body, function (err, restaurant){
			if (err) {
				// console.log('error from ctrl');
				// console.log(err.message);
				res.json(err);
	        } else {
	            res.json({restaurant});
	        }
		})
	},

	update: function (req, res) {
		Restaurant.updateOne({_id: req.params.id}, {$set: req.body}, { runValidators: true }, function (err, restaurant){
			if (err) {
				// console.log('error from ctrl');
				// console.log(err.message);
				res.json(err);
	        } else {
	            res.json(restaurant);
	        }
		})
	},

	delete: function (req, res) {
		Restaurant.deleteOne({_id: req.params.id}, function (err, restaurant){
			if (err) {
				res.json(err);
	        } else {
	            res.json(restaurant);
	        }
		})
	},

	indexR: function (req, res) {
		Rating.find({}, function(err, reviews){
			if (err) {
				res.json(err);
	        } else {
	            res.json({reviews});
	        }
		})
	},

	createR: function (req, res) {
		Rating.create(req.body, function (err, review){
			// console.log('create from ctrl');
			// console.log(review);
			if (err) {
				res.json(err);
	        } else {
	            Restaurant.findOneAndUpdate({_id: req.params.cakeId}, {$push: {ratings: review}}, { runValidators: true }, function(err, data){
                    if (err) {
						// console.log('error from ctrl');
						// console.log(err.message);
						res.json(err);
			        } else {
			            res.json({data});
			        }
                })
	        }
	    })
	},

	deleteR: function (req, res) {
		Rating.deleteOne({_id: req.params.id}, function (err, review){
			if (err) {
				res.json(err);
	        } else {
	            res.json(review);
	        }
		})
	}
}