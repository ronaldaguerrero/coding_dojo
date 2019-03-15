let quoteCtrl = require('./../controllers/quoteCtrl.js');


module.exports = function(app){
	app.get('/quotes', quoteCtrl.index);
	app.post('/quotes', quoteCtrl.create);
}


