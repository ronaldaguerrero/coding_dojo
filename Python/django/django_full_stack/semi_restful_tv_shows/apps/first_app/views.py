# views in first app folder
from django.shortcuts import render, redirect
from .models import Show
from datetime import datetime
from django.contrib import messages
# show all of the data from a table
def addpage(request):
	return render(request, "first_app/index.html")

def add(request):
	errors = Show.objects.validator(request.POST)
	# check if the errors dictionary has anything in it
	if len(errors) != 0:
	# if the errors dictionary contains anything, loop through each key-value pair and make a flash message
		for key, value in errors.items():
			messages.error(request, value)
	# redirect the user back to the form to fix the errorscopy
		return redirect('/addpage')
	temp_date = request.POST['rel_date']
	print('*' * 100)
	Show.objects.create(title=request.POST['title'], network=request.POST['net'],release_date=temp_date,description=request.POST['desc'])
	new = Show.objects.last()
	print(new.id)
	return redirect('/show/'+str(new.id))

def show(request, my_val):
	context = {
		'show': Show.objects.get(id=my_val),
	}
	return render(request, "first_app/show.html", context)

def all_shows(request):
	context = {
		"shows": Show.objects.all()
	}
	return render(request, "first_app/all_shows.html", context)

def edit(request, my_val):
	context = {
		'show': Show.objects.get(id=my_val),
		'date': Show.objects.get(id=my_val).release_date.strftime("%d/%m/%Y")
	}
	return render(request, "first_app/edits.html", context)

def update(request, my_val):
	u = Show.objects.get(id=my_val)
	errors = Show.objects.validator(request.POST)
	# check if the errors dictionary has anything in it
	if len(errors) != 0:
	# if the errors dictionary contains anything, loop through each key-value pair and make a flash message
		for key, value in errors.items():
			messages.error(request, value)
	# redirect the user back to the form to fix the errorscopy
		return redirect('/shows/'+str(u.id)+'/edit')
	temp_date = request.POST['rel_date']
	u = Show.objects.get(id=my_val)
	u.title=request.POST['title']
	u.network=request.POST['net']
	u.release_date=temp_date
	u.description=request.POST['desc']
	u.save()
	return redirect('/show/'+str(u.id))

def delete(request, my_val):
	delete = Show.objects.get(id=my_val)
	delete.delete()
	return redirect('/allshows')



