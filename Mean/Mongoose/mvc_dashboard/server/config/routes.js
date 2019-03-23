let dashCtrl = require('./../controllers/dashboardCtrl.js');

module.exports = function(app){
	app.get('/dogs/new', dashCtrl.create);

	app.post('/add', dashCtrl.add);

	app.get('/', dashCtrl.index);

	app.get('/dogs/edit/:id', dashCtrl.edit);

	app.get('/dogs/:id', dashCtrl.show);

	app.post('/update/:id', dashCtrl.update);

	app.post('/dogs/destroy/:id', dashCtrl.destroy);
}