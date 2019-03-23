let mainCtrl = require('./../controllers/mainCtrl.js');

module.exports = function(app){
	app.get('/products', mainCtrl.index);
	app.get('/products/:id', mainCtrl.show);
	app.post('/product', mainCtrl.create);
	app.put('/product/:id', mainCtrl.update);
	app.delete('/:id', mainCtrl.delete);
}