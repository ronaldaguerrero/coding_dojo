let express = require('express');
let app = express();
let mongoose = require('mongoose');
let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));

mongoose.connect("mongodb://localhost/1955Api", { useNewUrlParser: true });

require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);

app.listen(8000, function() {
  console.log("Listening on port 8000")
})