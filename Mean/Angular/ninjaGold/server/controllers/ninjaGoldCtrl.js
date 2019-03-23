let mongoose = require('mongoose');
let Ninja = mongoose.model('ninjas');

module.exports = {
	// index: function (req, res) {
	// 	Ninja.find({}, function(err, gold){
	// 		console.log('hello');
	// 		if (err) {
	// 			res.json(err);
	//         } else {
	//         	console.log('gold ctrl: ' + gold);
	//             res.json(gold);
	//         }
	// 	})
	// },
	// create: function (req, res) {
	// 	Ninja.create(req.body, function (err, gold){
	// 		if (err) {
	// 			res.json(err);
	//         } else {
	//         	console.log(gold);
	//             res.json({gold});
	//         }
	// 	})
	// },
}