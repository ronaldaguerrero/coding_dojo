let apiCtrl = require('./../controllers/apiCtrl.js');

module.exports = function(app){
	app.get('/', apiCtrl.index);
	app.get('/name/:name/', apiCtrl.create);
	app.get('/remove/:name/', apiCtrl.remove);
	app.get('/:name', apiCtrl.show);
}