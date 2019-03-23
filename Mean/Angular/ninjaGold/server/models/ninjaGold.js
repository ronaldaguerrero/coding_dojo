// model
const mongoose = require('mongoose');

const ninjaSchema = new mongoose.Schema({
	gold: {type: Number, default: 0},
	loc: {type: String, required: true},
}, {timestamps:true});

const Ninja = mongoose.model('ninjas', ninjaSchema);
