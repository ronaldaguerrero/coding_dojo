// model
const mongoose = require('mongoose');

const restaurantSchema = new mongoose.Schema({
	name: {type: String, required: true, minlength: 3},
	cuisine: {type: String, required: true, minlength: 3},
	ratings: [ratingSchema]
}, {timestamps:true});

const ratingSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 3},
    rating: {type: Number, required: true},
    cmt: {type: String, required: true, minlength: 3},
}, {timestamps:true});

const Restaurant = mongoose.model('restaurants', restaurantSchema);
const Rating = mongoose.model('ratings', ratingSchema);

