from django.shortcuts import render, redirect
from django.contrib import messages
from .models import *
import bcrypt

import re	# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

# Create your views here.
def index(request):
    print("*"*100)
    print('This is the index method')
    # 1. Query the database for all cars
    all_cars = Car.objects.all() # equivalent to all_cars = mysql.query_db('SELECT * FROM cars') in flask
    # 2. Create the context dictionary and add the cars to the dictionary
    context = {
        'cars': all_cars
    }
    # 3. Send the context dictionary to the template
    return render(request, 'first_app/index.html', context)
    # 4. Use {%%} tags to display each car's properties

def new(request):
    print("*"*100)
    print('This is the new method')
    return render(request, 'first_app/new.html')

def create(request):
    # # Method 1: No ModelManager
    # errors = {}
    # # Make sure the car name is at least 4 characters long
    # if len(request.POST['name'])<4:
    #     errors['name'] = "Name must be at least 4 characters long"
    # # Make sure the year is before 2019
    # if int(request.POST['year']) > 2019:
    #     errors['year'] = "Car must be made before 2019"
    
    # Method 2: ModelManager
    errors = Car.objects.validate_car(request.POST)


    if len(errors) != 0:
        for key, value in errors.items():
            messages.error(request,value)
        return redirect('/cars/new')
    else:
        # 1. pull the form information into a new instance of Car
        Car.objects.create(name=request.POST['name'], year=request.POST['year'])
        # Similar to code in shell, except the values must be pulled from request.POST
        return redirect('/')

def register_form(request):
    return render(request, 'first_app/register.html')

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
        return redirect('/register')
    else:
    # 2. If valid, hash the password with bcrypt
        hash1 = bcrypt.hashpw(request.POST['password'].encode(), bcrypt.gensalt())
        # 3. Run the query to add the user to the db
        new_user = User.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'], password=hash1)
        print('='*50)
        print('created a new user', new_user.__dict__)
        return redirect('/register')

def login(request):
    users_with_email = User.objects.filter(email=request.POST['email'])
    if len(users_with_email) > 0:
        enteredPassword = request.POST['password']
        existingpw = users_with_email[0].password
        check = bcrypt.checkpw(enteredPassword.encode(),existingpw.encode())
        if (check == True):
            request.session['user_id'] = users_with_email[0].id
            return redirect('/success')
        else:
            messages.error(request, "Invalid Login Info")
            return redirect('/register')
    else:
        messages.error(request, "Invalid Login Info")
        return redirect('/register')

def success(request):
    user = User.objects.get(id=request.session['user_id'])
    context = {
        'user': user,
    }
    return render(request, 'first_app/success.html', context)

def logout(request):
    request.session['user_id'] = None
    messages.error(request, "You have logged out")
    return redirect('/register')


# Login pseudocode
# 1. Query database for a user with the email address entered
# 2. If the user exists, use the bcrypt.checkpw function in order to check hashed password
# 3. If the function returns true, then add the user's id to request.session
# 4. redirect