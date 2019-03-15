from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt

import re	# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

def register_form(request):
    return render(request, 'first_app/index.html')

def register_user(request):
    # 1. Validate the form inputs
    errors = {}
    if len(request.POST['first_name'])<2:
        errors['first_name'] = "First name must be at least two characters long"
    if request.POST['first_name'].isalpha() == False:
        errors['first_name'] = "First name must have only letters"
    if len(request.POST['last_name'])<2:
        errors['last_name'] = "Last name must be at least two characters long"
    if request.POST['last_name'].isalpha() == False:
        errors['last_name'] = "Last name must have only letters"
    # These validations are new!! VVVVVVVVVVVVVV
    users_with_email = User.objects.filter(email=request.POST['email'])
    if len(users_with_email) > 0:
        errors['email'] = "Email is taken"
    if not EMAIL_REGEX.match(request.POST['email']):
        errors['email'] = "Email is invalid format."
    if len(request.POST['password'])< 8:
        errors['password'] = "Password must be at least 8 characters long"
    if request.POST['password'] != request.POST['confirm_password']:
        errors['password'] = "Password must match password confirmation"
    if len(errors) != 0:
        for key, value in errors.items():
            messages.error(request,value)
        return redirect('/')
    else:
    # 2. If valid, hash the password with bcrypt
        hash1 = bcrypt.hashpw(request.POST['password'].encode(), bcrypt.gensalt())
        # 3. Run the query to add the user to the db
        new_user = User.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'], password=hash1)
        request.session['user_id'] = User.objects.last().id
        print('='*50)
        print('created a new user', new_user.__dict__)
        return redirect('/dashboard')

def login(request):
    users_with_email = User.objects.filter(email=request.POST['email'])
    if len(users_with_email) > 0:
        enteredPassword = request.POST['password']
        existingpw = users_with_email[0].password
        check = bcrypt.checkpw(enteredPassword.encode(),existingpw.encode())
        if (check == True):
            request.session['user_id'] = users_with_email[0].id
            return redirect('/dashboard')
        else:
            messages.error(request, "Invalid Login Info")
            return redirect('/')
    else:
        messages.error(request, "Invalid Login Info")
        return redirect('/')

def dashboard(request):
    user = User.objects.get(id=request.session['user_id'])
    my_trips = user.trips.order_by('-created_at')
    context = {
        'user': user,
        'my_trips': my_trips,
    }
    print('$'*50)
    print(my_trips)
    return render(request, 'first_app/dashboard.html', context)

def trip_new(request):
	this_user = User.objects.get(id=request.session['user_id'])
	context = {
	'user': this_user
	}
	return render(request, 'first_app/create.html', context)

def add(request):
	errors = {}
	if len(request.POST['dest'])<3:
		errors['dest'] = "Destination name must be at least 3 characters long"
	if len(request.POST['start']) == 0:
		errors['start'] = "Must have a start date"
	if len(request.POST['end']) == 0:
		errors['end'] = "Must have an end date"
	if len(request.POST['plan']) <3:
		errors['plan'] = "Must have a plan"
	# check if the errors dictionary has anything in it
	if len(errors) != 0:
	# if the errors dictionary contains anything, loop through each key-value pair and make a flash message
		for key, value in errors.items():
			messages.error(request, value)
	# redirect the user back to the form to fix the errorscopy
		return redirect('/trips/new')
	start = request.POST['start']
	end = request.POST['end']
	this_user = User.objects.get(id=request.session['user_id'])
	trip = Trips.objects.create(destination=request.POST['dest'], start_date=start,end_date=end,plan=request.POST['plan'],user=this_user)
	return redirect('/dashboard')

def view(request, my_val):
	this_user = User.objects.get(id=request.session['user_id'])
	trip = Trips.objects.get(id=my_val)
	context = {
	'user': this_user.first_name,
	'trip': trip
	}
	return render(request, 'first_app/view_trip.html', context)

def remove(request, my_val):
	remove = Trips.objects.get(id=my_val)
	remove.delete()
	return redirect('/dashboard')

def edit(request, my_val):
	this_user = User.objects.get(id=request.session['user_id'])
	context = {
		'trip_id': Trips.objects.get(id=my_val).id,
		'trip': Trips.objects.get(id=my_val).destination,
		'start': Trips.objects.get(id=my_val).start_date.strftime("%d/%m/%Y"),
		'end': Trips.objects.get(id=my_val).end_date.strftime("%d/%m/%Y"),
		'plan': Trips.objects.get(id=my_val).plan,
		'user': this_user,
	}
	return render(request, "first_app/edit_trip.html", context)


def update(request, my_val):
	errors = {}
	if len(request.POST['dest'])<3:
		errors['dest'] = "Destination name must be at least 3 characters long"
	if (request.POST['start']) == None:
		errors['start'] = "Must have a start date"
	if request.POST['end'] == None:
		errors['end'] = "Must have an end date"
	if len(request.POST['plan']) <3:
		errors['plan'] = "Must have a plan"
	# check if the errors dictionary has anything in it
	if len(errors) != 0:
	# if the errors dictionary contains anything, loop through each key-value pair and make a flash message
		for key, value in errors.items():
			messages.error(request, value)
	# redirect the user back to the form to fix the errorscopy
		return redirect('/shows/'+str(u.id)+'/edit')
	u = Trips.objects.get(id=my_val)
	start_date = request.POST['start']
	end_date = request.POST['end']
	u.destination=request.POST['dest']
	u.start_date = start_date
	u.end_date = end_date
	u.plan=request.POST['plan']
	u.save()
	return redirect('/dashboard')

def logout(request):
	request.session['user_id'] = None
	messages.error(request, "You have logged out")
	return redirect('/')


# Login pseudocode
# 1. Query database for a user with the email address entered
# 2. If the user exists, use the bcrypt.checkpw function in order to check hashed password
# 3. If the function returns true, then add the user's id to request.session
# 4. redirect