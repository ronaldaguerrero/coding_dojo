### first app, def functions here ###
from django.shortcuts import render, HttpResponse
from .models import Author

def index(request):
    context = {"all_the_authors": Author.objects.all()}		# we're only sending up all the authors
    return render(request, "first_app/index.html", context)