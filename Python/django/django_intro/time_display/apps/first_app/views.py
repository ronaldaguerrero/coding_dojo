### first app view ###
from django.shortcuts import render, redirect, HttpResponse
from time import gmtime, strftime

def index(request):
    context = {
        "time": strftime("%b %d, %Y, %I:%M %p", gmtime())
    }
    return render(request, 'first_app/index.html', context)
