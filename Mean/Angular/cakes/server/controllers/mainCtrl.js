let mongoose = require('mongoose');
let Cake = mongoose.model('cakes');
let Rating = mongoose.model('ratings');

module.exports = {
	index: function (req, res) {
		Cake.find({}, function(err, cakes){
			if (err) {
				res.json(err);
	        } else {
	            res.json({cakes});
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

	show: function (req, res){
		Cake.find({_id: req.params.id}, function (err, cake){
			if (err) {
				res.json(err);
	        } else {
	            res.json({cake});
	        }
		})
	},

	create: function (req, res) {
		Cake.create(req.body, function (err, cake){
			if (err) {
				res.json(err);
	        } else {
	            res.json({cake});
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
	            Cake.findOneAndUpdate({_id: req.params.cakeId}, {$push: {ratings: review}}, function(err, data){
                    if(err){
                        res.json({message: "Error!", error: err});
                    }
                    else{
                        res.json({message: "Success!", added: true});
                    }
                })
	        }
	    })
	},

	update: function (req, res) {
		Cake.updateOne({_id: req.params.id}, {$set: req.body}, function (err, cake){
			if (err) {
				res.json(err);
	        } else {
	            res.json(cake);
	        }
		})
	},

	delete: function (req, res) {
		Cake.deleteOne({_id: req.params.id}, function (err, cake){
			if (err) {
				res.json(err);
	        } else {
	            res.json(cake);
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