from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

def index(request):
	return HttpResponse("TEST")

def random(request):
	if request.session['counter'] not in request.session:
		request.session['counter'] += 1
	
	random = get_random_string(length=14)
	context = {
		"random": random
	}
	print("*" * 50)
	print('random word is ' + random)
	print("*" * 50)
	return render(request, 'first_app/index.html', context)

def generate(request):
	return redirect(random)

def reset(request):
	request.session['counter'] = 0
	return redirect(random)