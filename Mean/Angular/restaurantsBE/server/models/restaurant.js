// model
const mongoose = require('mongoose');

const ratingSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: [3, 'Name must be more than 3 characters']},
    rating: {type: Number, required: true},
    cmt: {type: String, required: true, minlength: [3, 'Comment must be more than 3 characters']},
}, {timestamps:true});

const restaurantSchema = new mongoose.Schema({
	name: {type: String, required: [true, 'name is required'], minlength: [3, 'must be more than 3 characters']},
	cuisine: {type: String, required: true, minlength: [3, 'Cuisine must be more than 3 characters']},
	ratings: [ratingSchema]
}, {timestamps:true});

const Restaurant = mongoose.model('restaurants', restaurantSchema);
const Rating = mongoose.model('ratings', ratingSchema);

