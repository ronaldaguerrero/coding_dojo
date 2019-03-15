# method 1 --- inside views.py w/out Model Manager

from django.contrib import messages

def create(request):
# make sure the car name is at least 4 char long
	errors = {}
	if len(request.POST['name']) < 4:
		errors['name'] = 'Name must be at least 4 characters long'
# make sure the yeat is before 2019
	if int(request.POST['year']) > 2019:
		errors['year'] = 'Car must be made before 2019'

	if len(errors) != 0:
		for key, value in errors.items():
			messages.error(request, value)
		return redirect ('/new')
	else:
		Car.objects.create(name=request.POST['name'], year=request.POST['year'])
		return redirect('/')

# https://docs.djangoproject.com/en/1.10/ref/contrib/messages/

# {% if messages %}
# <ul class="messages">
#     {% for message in messages %}
#     <li{% if message.tags %} class="{{ message.tags }}"{% endif %}>{{ message }}</li>
#     {% endfor %}
# </ul>
# {% endif %} 

# method 2 -- inside models.py

from django.db import models

class CarManager(models.Manger)
	def validate_car(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['name']) < 4:
            errors["name"] = "Name must be at least 4 characters long"
        if len(postData['year']) > 2019:
            errors["year"] = "Car must be made before 2019"
        return errors

An edit also has to be made on classModel
ex/ objects = CarManager()    # add this line!

# inside views.py

errors = Car.objects.validate_car(request.POST)

if len(errors) != 0:
	for key, value in errors.items():
		messages.error(request, value)
	return redirect ('/new')
else:
	Car.objects.create(name=request.POST['name'], year=request.POST['year'])
	return redirect('/')