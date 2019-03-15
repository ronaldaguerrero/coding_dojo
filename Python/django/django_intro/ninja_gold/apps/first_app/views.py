from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
from random import *
from time import localtime, strftime

def index(request):
	if 'gold' not in request.session or 'activities' not in request.session:
		request.session['gold'] = 0
		request.session['activities'] = []
		print('resetting keys in request.session')
	time = {
		"time": strftime("%Y/%m/%d %I:%M %p", localtime())
	}
	return render(request, 'first_app/index.html', time)

def process_money(request):
	if request.method == "POST":
		if request.POST['type'] == 'farm':
			randomNum = int(randint(10,20))
			request.session['gold'] += randomNum
			request.session['activities'].append('Earned ' + str(randomNum) +' from the farm! ' + '(' + strftime("%Y/%m/%d %I:%M %p", localtime()) + ')')
			request.session.modified = True
		if request.POST['type'] == 'cave':
			randomNum = int(randint(5,10))
			request.session['gold'] += randomNum
			request.session['activities'].append('Earned ' + str(randomNum) +' from the cave! ' + '(' + strftime("%Y/%m/%d %I:%M %p", localtime()) + ')')
			request.session.modified = True
		if request.POST['type'] == 'house':
			randomNum = int(randint(2,5))
			request.session['activities'].append('Earned ' + str(randomNum) +' from the house! ' + '(' + strftime("%Y/%m/%d %I:%M %p", localtime()) + ')')
			request.session.modified = True
			request.session['gold'] += randomNum
		if request.POST['type'] == 'casino':
			randomNum = int(randint(-50,50))
			request.session['gold'] += randomNum
			if randomNum > 0:
				request.session['activities'].append('Earned ' + str(randomNum) +' from the casino! ' + '(' + strftime("%Y/%m/%d %I:%M %p", localtime()) + ')')
			else:
				request.session['activities'].append('Lost ' + str(randomNum * -1) +' from the casino! ' + '(' + strftime("%Y/%m/%d %I:%M %p", localtime()) + ')')
			request.session.modified = True
		print('temp gold is ', request.session['gold'])
		print('activity contents are: ', request.session['activities'])
		return redirect('/')

def reset(request):
	request.session['gold'] = 0
	request.session['activities'] = []
	return redirect('/')
