// model
const mongoose = require('mongoose');

const ratingSchema = new mongoose.Schema({
    rating: {type: Number},
    cmt: {type: String, default: ""},
}, {timestamps:true});

const cakeSchema = new mongoose.Schema({
    baker: {type: String, default: ""},
    img: {type: String, default: ""},
    ratings: [ratingSchema]
}, {timestamps:true});

const Cake = mongoose.model('cakes', cakeSchema);
const Rating = mongoose.model('ratings', ratingSchema);

