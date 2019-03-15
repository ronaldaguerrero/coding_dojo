### first app ###
from django.shortcuts import render, HttpResponse, redirect
# def index(request):
#     return HttpResponse("placeholder to later display a list of all blogs!")

def newone(request):
    return HttpResponse("place holder to display a new form to create a new blog")

def create(request):
    return redirect("/")

def show(request, my_val):
    return HttpResponse("placeholder to display blog number "+str(my_val))

def edit(request, my_val):
    return HttpResponse("placeholder to edit blog "+str(my_val))

def delete(request, my_val):
    return HttpResponse("placeholder for destroy")

def index(request):
    context = {
    	"name": "Noelle",
    	"favorite_color": "turquoise",
    	"pets": ["Bruce", "Fitz", "Georgie"]
    }
    
    return render(request, 'first_app/index.html', context)

def submit_form(request):
    if request.method=="POST":
        print(request.POST) # request.POST represents the form information (like request.form in Flask)

        request.session['one'] = request.POST['one']
        request.session['two'] = request.POST['two']
        return redirect("/")
