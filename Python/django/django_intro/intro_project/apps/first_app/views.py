### first app, def functions here ###
from django.shortcuts import render, HttpResponse
def index(request):
    return HttpResponse("main page from first app --- this is the equivalent of @app.route('/')!")

def new(request):
    return HttpResponse("new page from the first app")