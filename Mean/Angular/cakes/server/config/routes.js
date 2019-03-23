let mainCtrl = require('./../controllers/mainCtrl.js');

module.exports = function(app){
	app.get('/cakes', mainCtrl.index);
	app.get('/cake/:id', mainCtrl.show);
	app.post('/cake', mainCtrl.create);
	app.put('/cake/:id', mainCtrl.update);
	app.delete('/:id', mainCtrl.delete);

	app.get('/reviews', mainCtrl.indexR);
	app.post('/review/:cakeId', mainCtrl.createR);
	app.delete('/review/:id', mainCtrl.deleteR);
}