// model
const mongoose = require('mongoose');

const dogSchema = new mongoose.Schema({
  name: { type: String, required: true, minlength: 1},
  breed: { type: String, required: true, minlength: 1},
}, {timestamps: true });

const Dog = mongoose.model('dogs', dogSchema);