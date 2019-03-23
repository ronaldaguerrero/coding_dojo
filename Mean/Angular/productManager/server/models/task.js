// model
const mongoose = require('mongoose');

const productSchema = new mongoose.Schema({
	title: {type: String, required: true, minlength: 4},
	price: {type: Number, required: true},
	img: {type: String}
}, {timestamps:true});

const Product = mongoose.model('products', productSchema);
