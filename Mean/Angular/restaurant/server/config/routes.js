let mainCtrl = require('./../controllers/mainCtrl.js');

module.exports = function(app){
	app.get('/restaurants', mainCtrl.index);
	app.get('/restaurant/:id', mainCtrl.show);
	app.post('/restaurant', mainCtrl.create);
	app.put('/restaurant/:id', mainCtrl.update);
	app.delete('/:id', mainCtrl.delete);
}