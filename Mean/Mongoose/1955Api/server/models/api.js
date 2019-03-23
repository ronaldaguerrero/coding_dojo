// model
const mongoose = require('mongoose');

const apiSchema = new mongoose.Schema({
	name: {type: String, required: true}
}, {timestamps:true});

const Person = mongoose.model('persons', apiSchema);
